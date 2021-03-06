package com.company;

import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.BufferedImage;

public class Main {

    public static void main(String[] args) {
        //args[0] = encode/decode
        //args[1] = file to encode/decode
        if (args[0].equalsIgnoreCase("encode"))
            encode(args[1]);
        else if (args[0].equalsIgnoreCase("decode")) {
            if (args.length == 2) decode(args[1], "decoded.txt");
            else decode(args[1], args[2]);
        }
    }

    public static void encode(String filename) {
        try {
            File file = new File(filename);
            FileInputStream fStream = new FileInputStream(file);
            int messageSize, dimension, arrayPop = 0, temp1, temp2;
            int[][][] message;

            messageSize = fStream.available() + 3;  //To account for first pixel of three bytes
            dimension = ((int) Math.ceil(Math.sqrt((messageSize + 1) / 3)));
            message = new int[dimension][dimension][3];

            //message[][][] population start
            message[0][0][0] = messageSize / (256 * 256);
            message[0][0][1] = (messageSize % (256 * 256)) / 256;
            message[0][0][2] = messageSize % 256;

//            System.out.println("{" + message[0][0][0] + " " + message[0][0][1] + " " + message[0][0][2] + "} ");

            for (int y = 0; y < dimension; y++) {
                for (int x = 0; x < dimension; x++) {
                    if (arrayPop < messageSize && arrayPop != 0) {
                        message[y][x][0] = fStream.read();
                        temp1 = fStream.read();
                        message[y][x][1] = (temp1 != -1) ? temp1 : 0;
                        temp2 = fStream.read();
                        message[y][x][2] = (temp2 != -1) ? temp2 : 0;
                        arrayPop += 3;
//                        System.out.print("{" + message[y][x][0] + " " + message[y][x][1] + " " + message[y][x][2] + "} ");
                    } else {
                        arrayPop += 3;
                    }
                }
//                System.out.println();
            }
            arrayPop = 0;
            //message[][][] population end

            //image pixel population start
            BufferedImage img = new BufferedImage(dimension, dimension, BufferedImage.TYPE_INT_RGB);

            for (int y = 0; y < dimension; y++) {
                for (int x = 0; x < dimension; x++) {
                    if (arrayPop <= messageSize) {
                        int col = (message[y][x][0] << 16) | (message[y][x][1] << 8) | message[y][x][2];
                        img.setRGB(x, y, col);
                        arrayPop += 3;
                    }
                }
            }
            //image pixel population end

            //image export
            File export = new File("encoded.png");
            ImageIO.write(img, "PNG", export);

            System.out.println("Encode completed");

        } catch (Throwable e) {
            System.out.println(e.toString());
        }
    }

    public static void decode(String filename, String endFilename) {
        try {
            BufferedImage input = ImageIO.read(new File(filename));
            File endFile = new File(endFilename);
            FileOutputStream fop = new FileOutputStream(endFile);
            int messageSize = (input.getRGB(0, 0) >> 16 & 0xFF) * 256 * 256 + (input.getRGB(0, 0) >> 8 & 0xFF) * 256 + (input.getRGB(0, 0) & 0xFF) - 1;
            int dimension = input.getHeight();
            int arrayPop = 0;
//            System.out.println(messageSize);
            String message = "";

            for (int y = 0; y < dimension; y++) {
                for (int x = 0; x < dimension; x++) {
                    if (arrayPop <= messageSize && arrayPop != 0) {
//                        System.out.print((char) (input.getRGB(x, y) >> 16 & 0xFF));
                        message += ((char) (input.getRGB(x, y) >> 16 & 0xFF));
                        arrayPop++;
//                        System.out.print((char) (input.getRGB(x, y) >> 8 & 0xFF));
                        if (arrayPop <= messageSize)
                            message += ((char) (input.getRGB(x, y) >> 8 & 0xFF));
                        arrayPop++;
//                        System.out.print((char) (input.getRGB(x, y) & 0xFF));
                        if (arrayPop <= messageSize)
                            message += ((char) (input.getRGB(x, y) & 0xFF));
                        arrayPop++;
                    } else {
                        arrayPop += 3;
                    }
                }
            }

            byte[] messageInBytes = message.getBytes();
            fop.write(messageInBytes);
            fop.flush();
            fop.close();

//            System.out.println(message);

            System.out.println("\nDecode completed");

        } catch (Throwable e) {
            System.out.println(e.toString());
        }
    }
}