function message = decryptRSA(cipher, n, d)
%Decrypts the message using the private key
for i=1:1:length(cipher)
    message(i) = char(double(mod(vpi(cipher(i))^d, vpi(n))))
end

