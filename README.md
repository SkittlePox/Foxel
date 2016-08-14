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

Foxel encodes the text from a given .txt file into a .png. It's a cool proof of concept of an image cryptography technique.

It has the capacity to store 65,535 characters (256*255 + 255) while possibly being able to store at least 16,777,215 characters (256^2 * 255 + 256*255 + 255) but even more probably store an enormous finite amount of characters.
