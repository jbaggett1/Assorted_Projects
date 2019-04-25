function cipher = encryptRSA(message, e, n)
%converts plaintext to the cipher text 
 %this corresponds to the amount of letters and common thin
pt = double(message)

for i=1:1:length(pt)
    cipher(i) = mod(vpi(pt(i))^e, vpi(n))
end

