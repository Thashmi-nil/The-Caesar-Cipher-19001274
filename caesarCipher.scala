import scala.io.StdIn._

object caesarCipher{
    //function for encryption
    def encrytion(c:Char,key:Int,a:String):Char={
        if(c>= 'a' && c <= 'z'){                    //check for lowercase letters
            a((a.indexOf(c.toLower)+key)%a.size)
        }else{                                      //check for uppercase letters
            a((a.indexOf(c.toUpper)+key)%a.size)
        }
    }
    //function for decryption
    def decrytion(c:Char,key:Int,a:String):Char={   
        if(c>= 'a' && c <= 'z'){                    //check for lowercase letters
            a((a.indexOf(c.toLower)-key)%a.size)
        }else{                                      //check for uppercase letters
            a((a.indexOf(c.toUpper)-key)%a.size)
        }
    }
    //map the relevant text by calling the relevant function
    def cipher(algo:(Char,Int,String)=>Char,t:String,key:Int,a:String):String={
        // println("Ok")
        t.map(algo(_,key,a))
    }

    def main(args: Array[String]){

        //The plaintext only contains { English_alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ or abcdefghijklmnopqrstuvwxyz")/spaces(" ")/comma(",")/fullstop(".") }
        val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ%^!~&,/+-*$./+-*@ /+-*#"
        
        print("-------------------\n")
        print("Enter the plaintext : ")
        val text = readLine()
        print("-------------------\n")

        val encryptionCode = cipher(encrytion,text,5,alphabet)              //encrypt

        val decryptionCode = cipher(decrytion,encryptionCode,5,alphabet)    //decrypt

        println("Encrypted text      : "+encryptionCode)
        print("-------------------\n")
        println("Decrypted text      : "+decryptionCode)
        print("-------------------\n")
    }

}