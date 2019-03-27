package assembler;


public class primary_memory
{
    //
    private String[] memory;
    final int stack_start= 268435;//2^28-3-1
    final int heap_start= 268435;//2^28
    final int instruction_start=0;//no reserved,obvio !!
    int[] register;
    String ir;
    int ra,rb,rx,ry,rz,pc,iv;
    
    int parseint(String binaryInt,int t) {
        //Check if the number is negative.
        //We know it's negative if it starts with a 1
        if (binaryInt.charAt(0) == '1') {
            //Call our invert digits method
            String invertedInt = invertDigits(binaryInt);
            //Change this to decimal format.
            int decimalValue = Integer.parseInt(invertedInt, 2);
            //Add 1 to the curernt decimal and multiply it by -1
            //because we know it's a negative number
            decimalValue = (decimalValue + 1) * -1;
            //return the final result
            return decimalValue;
        } else {
            //Else we know it's a positive number, so just convert
            //the number to decimal base.
            return Integer.parseInt(binaryInt, 2);
        }
    }
    
    String invertDigits(String binaryInt) {
        String result = binaryInt;
        result = result.replace("0", " "); //temp replace 0s
        result = result.replace("1", "0"); //replace 1s with 0s
        result = result.replace(" ", "1"); //put the 1s back in
        return result;
    }










    //the above values are chosen arbitrarily
    primary_memory()
    {       
        memory=new String[268435]; //max-memory=2^28;
        for(int i=0;i< 268435;i++) memory[i]="00000000";
        register=new int[32];

        for(int i=0;i<32;i++)
        {
            register[i]=0;
        }

        register[2]=stack_start;
        register[3]=heap_start;
        pc=ra=rb=rx=ry=rz=0;
        ///////////////////////////////
        //memory[heap_start]="00000001";
        ///////////////////////////////
    }
    //////////////////////////////////////////////////////////////////
    //  input is binary string  //
    String loadbytestr(int addr) {
        return memory[addr];
    }

    String loadhalfstr(int addr) {
        return memory[addr + 1] + memory[addr];
    }

    String loadwordstr(int addr) {

        // System.out.println(addr+memory[addr+3]+memory[addr+2]+memory[addr+1]+memory[addr]);
        return memory[addr + 3] + memory[addr + 2] + memory[addr + 1] + memory[addr];
    }
    
    void storebytestr(int addr,String byte_in)
    {
        memory[addr]=byte_in.substring(0,8);

    }
    void storewordstr(int addr,String word_in)
    {
        //little endian//
        //System.out.println(word_in);
        memory[addr]  =word_in.substring(24,32);
        memory[addr+1]=word_in.substring(16,24);
        memory[addr+2]=word_in.substring(8 ,16);
        memory[addr+3]=word_in.substring(0 , 8);
        //System.out.println(memory[addr + 3] + memory[addr + 2] + memory[addr + 1] + memory[addr]+"-");
        
    }
    void storehalfstr(int addr,String half_in)
    {
        memory[addr]=half_in.substring(8 ,16);
        memory[addr+1]=half_in.substring(0 , 8);
    }

    ///////////////////////////// output is binary string /////////
    
    int loadbyte(int addr)
    {
        int itemp = parseint(memory[addr], 2);
        return itemp;
    }
    int loadhalf(int addr)
    {
        String rets= memory[addr+1]+memory[addr];
        int itemp = parseint(rets, 2);
        return itemp;
    }
    int loadword(int addr)
    {

        //System.out.println(addr+memory[addr+3]+memory[addr+2]+memory[addr+1]+memory[addr]);
        String rets=memory[addr+3]+memory[addr+2]+memory[addr+1]+memory[addr];
        int itemp = parseint(rets, 2);
        ////////////////////////////////////
        //System.out.println(itemp+":"+addr+":"+rets);
        ////////////////////////////////////
        return itemp;
    }

    void storebyte(int addr, int num) 
    {   
        String bin_line = Integer.toBinaryString(num);
        String temp = "";
        for (int i = 0; i < 8 - bin_line.length(); i++) {
            if(num>=0)temp = temp + "0";
            else temp=temp+"1";
        }
        bin_line=temp+bin_line;
        bin_line = bin_line.substring(bin_line.length() - 8, bin_line.length());//15
        memory[addr] = bin_line;

    }

    void storeword(int addr, int num) {
        // little endian//
        // System.out.println(word_in);
        String bin_line = Integer.toBinaryString(num);
        String temp = "";
        for (int i = 0; i < 32 - bin_line.length(); i++) {
            if(num>=0)temp = temp + "0";
            else temp=temp+"1";
        }
        bin_line=temp+bin_line;
        bin_line = bin_line.substring(bin_line.length() - 32, bin_line.length());
        memory[addr] = bin_line.substring(24, 32);
        memory[addr + 1] = bin_line.substring(16, 24);
        memory[addr + 2] = bin_line.substring(8, 16);
        memory[addr + 3] = bin_line.substring(0, 8);
        // System.out.println(memory[addr + 3] + memory[addr + 2] + memory[addr + 1] +
        // memory[addr]+"-");

    }

    void storehalf(int addr, int num) {
       String bin_line = Integer.toBinaryString(num);
        String temp = "";
        for (int i = 0; i < 16 - bin_line.length(); i++) {
            if(num>=0)temp = temp + "0";
            else temp=temp+"1";
        }
        bin_line = temp + bin_line;
        bin_line = bin_line.substring(bin_line.length() - 16, bin_line.length());
        
        memory[addr] = bin_line.substring(8, 16);
        memory[addr + 1] = bin_line.substring(0, 8);
    }

    ///////////////////////////// output is binary string /////////

    
    

}