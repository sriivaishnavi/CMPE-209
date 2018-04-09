import java.lang.*;
public class Affinecipher
{
 public static void main(String[] args)
{
 String plaintext = "TWENTY FIFTEEN";
 int a = 5;
 int b = 3;
 String encryptedmsg = affine_encrypt(plaintext,a,b);
 String decryptedmsg = affine_decrypt(encryptedmsg,a,b);
 System.out.println("Input: " + plaintext);
 System.out.println("Encrypted: " + encryptedmsg);
 System.out.println("Decrypted: " + decryptedmsg);
 }
 public static String  affine_encrypt(String plaintext,int a,int b)
 {
 String ciphermsg = "";
 char encodedchar = ' ';
 for (int i = 0; i < plaintext.length(); i++)
 {
 char c = plaintext.charAt(i);
 if (Character.isLetter(c)) // checking whether letter or not
 {
 int p = c - 'A' ;
 encodedchar = (char) ((((a*p) +b)%26) + 'A');
 }
 else // For space {
encodedchar = ' ';
 }
 ciphermsg = ciphermsg + encodedchar;
 }
 return ciphermsg;
 }
public static String affine_decrypt(String encryptedmsg,int a,int b)
{
String originalmsg = "";
int inverse = 0;
char decodedchar;
for (int k=1; k<26; k++) //finding inverse of  a
 if ((a*k) % 26 == 1)
 inverse = k;
 for (int i = 0; i < encryptedmsg.length(); i++)
 {
 char c = encryptedmsg.charAt(i);
 if (Character.isLetter(c)) //check whether letter or not
 {
 int p = c + 'A' ;
 decodedchar = (char) (((inverse *(p-b)) % 26) +'A');
 }
 else // For space
 {
 decodedchar = ' ';
 }
 originalmsg = originalmsg + decodedchar;
 }
 return originalmsg;
 }
}
