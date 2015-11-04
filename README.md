View Raw Please
 ________ ________     ___    ___ _______   ___          
|\  _____\\   __  \   |\  \  /  /|\  ___ \ |\  \         
\ \  \__/\ \  \|\  \  \ \  \/  / | \   __/|\ \  \        
 \ \   __\\ \  \\\  \  \ \    / / \ \  \_|/_\ \  \       
  \ \  \_| \ \  \\\  \  /     \/   \ \  \_|\ \ \  \____  
   \ \__\   \ \_______\/  /\   \    \ \_______\ \_______\
    \|__|    \|_______/__/ /\ __\    \|_______|\|_______|
                      |__|/ \|__|                        

A text to image encoder and back.

Foxel encodes the text from a given .txt file into a .png. It's a cool proof of concept of image cryptography.

It has the capacity to store 65,535 characters (256*255 + 255) while possibly being able to hold at least 16,777,215 characters (256^2 * 255 + 256*255 + 255) but probably an enormous finite amount of characters if written in.
