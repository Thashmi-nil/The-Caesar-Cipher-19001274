import scala.io.StdIn._

object caesarCipher{
    
    def encrytion(c:Char,key:Int,a:String):Char={
        if(c>= 'a' && c <= 'z'){                    
            a((a.indexOf(c.toLower)+key)%a.size)
        }else{                                      
            a((a.indexOf(c.toUpper)+key)%a.size)
        }
    }
    
    def decrytion(c:Char,key:Int,a:String):Char={   
        if(c>= 'a' && c <= 'z'){                    
            a((a.indexOf(c.toLower)-key)%a.size)
        }else{                                      
            a((a.indexOf(c.toUpper)-key)%a.size)
        }
    }

    def cipher(algo:(Char,Int,String)=>Char,t:String,key:Int,a:String):String={
        // println("Ok")
        t.map(algo(_,key,a))
    }

    def main(args: Array[String]){

        
        val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ%^!~&,/+-*$./+-*@ /+-*#"
        
        print("-------------------\n")
        print("Enter the plaintext : ")
        val text = readLine()
        print("-------------------\n")

        val encryptionCode = cipher(encrytion,text,5,alphabet)

        val decryptionCode = cipher(decrytion,encryptionCode,5,alphabet)

        println("Encrypted text      : "+encryptionCode)
        print("-------------------\n")
        println("Decrypted text      : "+decryptionCode)
        print("-------------------\n")
    }

}