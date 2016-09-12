package com.ccsi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	    int[] arr={1,2,3,4,5,2,7};
        System.out.println(containsNearbyDuplicate1(arr,3));
    }
    //Given an array of integers and an integer k,find out whether there are two distinct
    //indices i and j in the array such that nums[i]=nums[j] and the difference between
    //i and j is at most k
    //1.Set
    public static boolean containsNearbyDuplicate(int[] nums,int k){
        if(nums==null||nums.length==0)return false;
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i]))return true;
            if(set.size()>k)set.remove(nums[i-k]);
        }
        return false;
    }
    //2.Map
    public static boolean containsNearbyDuplicate1(int[] nums,int k){
        if(nums==null||nums.length==0)return false;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                if(Math.abs(i-map.get(nums[i]))<=k)return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
