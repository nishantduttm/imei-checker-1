package com.example.demo.beans;

import java.util.Arrays;

import lombok.Data;
@Data
public class IMEI {
   String imei;

   public String getImei() {
       return this.toString();
   }

   public void setImei(String imei) {
       this.imei = imei;
   }
   public IMEI(String code){
        this.imei = code;
    }
    public IMEI(){
    }
  public void correct(){
       int sum = 0;
       char[] arr = imei.toCharArray();
       for(int i = 14; i >= 0; i--){
           if(i % 2 != 0){
               int num = 2 * (arr[i] - '0');
               sum += num / 10;
               sum += num % 10;
           }else{
               sum += (arr[i] - '0');
           }
       }
       //System.out.println(sum);
       if(sum % 10 != 0){
           int sumExcludingLastDigit = sum - (arr[14] - '0');
           int i = sumExcludingLastDigit / 10;
           arr[14] = (char)(((i + 1) * 10 - (sumExcludingLastDigit)) + '0');
           imei = new String(arr);
       }
   }
    public boolean isValid(){
        if(imei.length() != 15){
            return false;
        }
        return true;
    }
   public int getLastDigit(){
       return imei.charAt(14) - '0';
   }
}
