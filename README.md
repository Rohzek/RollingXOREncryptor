# RollingXOREncryptor

![alt text](https://github.com/Rohzek/RollingXOREncryptor/blob/master/perm.png?raw=true "Example Image")

This program takes text in, and puts hex out that's been encrypted with Rolling [XOR](https://en.wikipedia.org/wiki/XOR_cipher) type encryption.
It can also take encrypted hex in, and put out original the decrypted text.
(We stop at hex, when it comes to encryption, as often converting the encrypted hex to ascii characters results in invalid characters, and can lose data completely when copied.)

It provides data at each step of the way, showing the unencrypted hex, unencrypted binary, encrypted binary, and encrypted hex for the encryption process, and similar for the output process, so that you can look at each step side by side and learn how the algorithm works.
