package software;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Lab_2{
    public static void main(String args[]) throws IOException {
        //Read File to Process
        String path = "";
        int mode_choose = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the path of the file in an absolute path:");
        //For example C:\Users\DELL\Desktop\test.c
        path = sc.next();
        System.out.println("Please enter the select_mod");
        mode_choose = sc.nextInt();

        String read_string;
        FileInputStream inputStream = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        int select_mod[] = {1,2,3,4};
        int num_single_else = 0;
        int num_if_else_if_else = 0;
        int num_if_else = 0;
        int num_keyWords = 0;
        String []key=  {"auto","double","int","struct","break","else","long","switch",
                "case","enum","register","typedef","char","extern","return","union",
                "const","float","short","unsigned","continue","for","signed","void",
                "default","goto","sizeof","volatile","do","if","while","static","elseif"};
        int j = 0;
        StringBuilder ss = new StringBuilder();
        while ((read_string = bufferedReader.readLine())!=null){
            read_string = read_string.replace(':', ' ');
            if(read_string.matches("(.*)//(.*)")){
                String b[] = read_string.split("//");
                ss.append(b[0]+" ");
            }else{
                ss.append(read_string+" ");
            }
        }
        inputStream.close();
        bufferedReader.close();

        //Converts the read content to a string format
        String s = ss.toString();
        Pattern p = Pattern.compile("\"(.*?)\"");
        Matcher m = p.matcher(s);
        while(m.find()){
            s=s.replace(m.group()," ");
            p=Pattern.compile("\"(.*?)\"");
            m=p.matcher(s);
        }
        p=Pattern.compile("/\\**(.*?)/");
        m=p.matcher(s);
        while(m.find()){
            s=s.replace(m.group()," ");
            m=p.matcher(s);
        }
        if(s.isEmpty())
        {System.out.println("Wrong Format");
            System.exit(0);
        }
        s=s.replace("["," ");
        s=s.replace("]"," ");
        s=s.replace("-","a");
        s=s.replace("*","a");
        s=s.replace("/","a");
        s=s.replace("+","a");
        s=s.replace(">","a");
        s=s.replace("=","a");
        s=s.replace("!","a");
        s=s.replace(":","a");
        s=s.replace("\\","a");
        s= s.replaceAll("[^a-zA-Z]", " ");
        String []s1=s.split("[  ' ']");
        //Choose select_mod at least 1, count the number of all the keywords
        if(mode_choose == select_mod[0] || mode_choose == select_mod[1] || mode_choose == select_mod[2] || mode_choose == select_mod[3]) {
            for(int i=0;i<s1.length;i++) {
                for( j=0;j<key.length;j++){
                    if(s1[i].equals(key[j])) {
                        num_keyWords ++;
                    }
                }
            }
            System.out.println("total num: "+num_keyWords);
        }

        //Choose select_mod at least 2,count the number of keywords switch and cases
        if(mode_choose == select_mod[1] || mode_choose == select_mod[2] || mode_choose == select_mod[3]) {
            //Find the number of case with different switch
            Vector vec_case = new Vector(4);
            int num_case = 0;
            int index = -1;
            for(int i=0;i<s1.length;i++) {
                if(s1[i].equals("switch")){
                    index++;
                    num_case=0;
                    vec_case.add(index,num_case);
                }
                if(s1[i].equals("case")){
                    num_case++;
                    vec_case.add(index,num_case);
                }
            }
            System.out.println("switch num: "+(index+1));
            System.out.print("case num: ");
            if(index == -1) {
                System.out.println(0);
            }
            else {
                for(int t=0;t<=index;t++){
                    System.out.print(vec_case.get(t)+" ");
                }
                System.out.println();
            }
        }

        //Choose the select_mod at least 3,count the number of if-else structure
        if(mode_choose == select_mod[2] || mode_choose == select_mod[3]) {
            for(int i=0;i<s1.length;i++) {
                if(i!=0) {
                    if(s1[i].equals("if")&&!s1[i-1].equals("else")) {
                        int init = i + 1;
                        if(i<s1.length-2) {
                            while((!(s1[i+1].equals("else")&&!s1[i+2].equals("if")))&&i<s1.length-3) {
                                i++;
                            }
                        }
                        else {
                            break;
                        }
                        int tmp = i;
                        boolean flag = false;
                        boolean flag2 = true;
                        for(int t = init;t<tmp;t++) {
                            if(s1[t].equals("if")&&!s1[t-1].equals("else")) {
                                for(int k = t;k<tmp;k++) {
                                    if(s1[k].equals("else")) {
                                        flag2 = false;
                                        break;
                                    }
                                }
                                if(flag2) num_if_else ++ ;
                                flag = true;
                                break;
                            }
                        }
                        if(flag) {
                            if(i<s1.length-2) {
                                while(!(s1[i+1].equals("else")&&!s1[i+2].equals("if"))) {
                                    i++;
                                }
                            }
                            else {
                                break;
                            }
                            num_if_else ++;
                        }
                    }
                }
            }
            System.out.println("if-else num: "+num_if_else);
        }
        //choose select_mod 4,count the number of if-else if-else structure
        if(mode_choose == select_mod[3]) {
            for(int i=0;i<s1.length;i++) {
                if(i < s1.length - 1) {
                    if(s1[i].equals("else")&&!s1[i+1].equals("if")){
                        num_single_else ++;
                    }
                }
                if(i == s1.length-1) {
                    if(s1[i].equals("else")) {
                        num_single_else ++;
                    }
                }
            }
            num_if_else_if_else = num_single_else - num_if_else;
            System.out.println("if -else if- else num: "+num_if_else_if_else);
        }
    }
}