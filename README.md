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

As of now it uses one byte to store the length of the encoded message and therefore we are stuck with 256 characters of space maximum.

With some more time I can increase the amount of space to 65,536 (256^2) by allocating another byte.
