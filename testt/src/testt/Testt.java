package testt;
import java.util.*;
public class Testt {
    static boolean isInfix(String text){
        for(int i =0;i<text.length();i++){
            char c = text.charAt(i);
            if(i%2!=0){
                if(c=='+' || c=='-' || c=='*' || c=='/'){
                    continue;
                }
                else{
                    return false;
                }
            }
            else{
                int z = (int) c;
                if(z<65 || z>90){
                    return false;
                }
            }
        }
        return true;
    }
    static String genStr(int n){
        String str = "";
        for(int i = 0;i<n;i++){
            int num = new Random().nextInt(26)+65;
            char a = (char)num;
            str += a;
        }
        return str;
    }
    static String genInfix(int n){
        int ac = 65;
        int num = 0;
        String str = "";
        if(n%2==0){
            n++;
        }
        for(int i=0;i<n;i++){
            if(i%2==0){
                char a = (char)ac;
                str += a;
                ac++;
            }
            else{
                num = new Random().nextInt(6)+42;
                if(num == 44 || num == 46){
                    num++;
                }
                char a = (char)num;
                str += a;
            }
            
        }
            return str;
    }
    static String infixToPostfix(String text){
        Stack <Character> s1 = new Stack<>();
        String str = "";
        for(int i=0;i<text.length();i++){
            char c = text.charAt(i);
            int z = (int) c;
            if(i%2==0){
                str += c;
            }
            else{
                if(s1.isEmpty()){
                    s1.push(c);
                }
                else if(c=='+'||c=='-'){
                    if(s1.peek()=='*'||s1.peek()=='/'){
                        while(!(s1.isEmpty())){
                            str+=s1.pop();
                        }
                        s1.push(c);
                    }
                    else if(s1.peek()=='+'||s1.peek()=='-'){
                        while(!(s1.isEmpty())){
                            str+=s1.pop();
                        }
                        s1.push(c);
                    }                
                }
                else if(c=='*'||c=='/'){
                    while(s1.peek()==('*')||s1.peek()==('/')){
                        str+=s1.pop();
                        if(s1.isEmpty()){
                            break;
                        }
                    }
                    s1.push(c);
                }
            }
        }
        while(!(s1.isEmpty())){
            str+=s1.pop();
        }
        return str;
    }
    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            int num = new Random().nextInt(99)+1;
            String str = null;
            if(num<=60){
                str = genInfix(new Random().nextInt(10)+3);
                System.out.print(str);
            }
            else{
                str = genStr(new Random().nextInt(10)+3);
                System.out.print(str);
            }
            if(isInfix(str)){
                System.out.println(" "+infixToPostfix(str));
            }
            else{
                System.out.println(" Input error");
            }
            
        }
    }
    
}
