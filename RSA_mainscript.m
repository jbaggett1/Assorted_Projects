% ========================================================================
% Class Exercise 1                                   Problem: 1
% Your Name                                          Date: 1/15/2019
% ------------------------------------------------------------------------
% This in-class exercise creates the m-file header that you will use for
% the remainder of your semester.
% ========================================================================
clear; clc;
fprintf('Problem 1\n');

%RSA Encryption Main Script 
%pick primes generates the primes for the encryption
%encrypt(p1, p2) takes in these two primes to do the encryption and returns
%the private key to decrypt them 
main_loop = 1
check = 0;
tab = 0;
while (main_loop == 1)
    if tab > 10
        fprintf('Error, re-run');
        break;
    end
tab = tab+1 %makes sure no infinite loop occurs    
up = 500;
[p1 p2 n] = pick_primes(up)
phi_n = (p1-1)*(p2-1)
flag = 1
for i=phi_n:-1:3
    
    if gcd(i, phi_n) == 1 && isprime(i) == 0
        e = i
        break;
    
    elseif i==3
        main_loop = 1;
        check = 1 %for the next loop
    end
end
%d*e = 1 mod(phi_n)
if check == 1
        main_loop = 1;
        
else
    for i=2:1:e-1

    if rem((e*i - 1),phi_n) == 0
        d = i
        main_loop = 0;
        break;
    elseif i==e-1
        flag = 0;
        fprintf('No d found, error');
        main_loop = 1;
    end
end
end
    

end
stng = input('Please enter a string to encrypt\n','s');

tic
 test = encryptRSA(stng, e, n)
 char(double(test))
 y=toc 
tic
 test2 = decryptRSA(test, n, d)
z=toc
fid = fopen('Matlab_Runtimes_Encrypt.txt','at');
fprintf(fid, '%.0f\t%.5f\n',up,y);
fid = fopen('Matlab_Runtimes_Decrypt.txt','at');
fprintf(fid, '%.0f\t%.5f\n',up,z);


plotOverhead('Matlab_Runtimes_Encrypt.txt');
plotOverhead('Matlab_Runtimes_Decrypt.txt');
