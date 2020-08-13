package GS;


import java.util.*;
public class StrangeSort {

    static class sortObj{
        String ori;
        String aft;
        int pos;
        sortObj(String s,int p){
            this.ori = s;
            this.pos = p;
        }
    }

    public static String[] strangeSorting1(int[] m,String[] nums){
        Map<Integer,Integer> mapping  = new HashMap<>();
        for(int i=0;i<m.length;i++) {
            mapping.put(m[i], i);
        }
        List<sortObj> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            sortObj o1 = new sortObj(nums[i],i);
            StringBuilder sb1 = new StringBuilder();
            for(char c : nums[i].toCharArray()){
                if(mapping.containsKey(c-'0')){
                    sb1.append(mapping.get(c-'0'));
                }
            }
            o1.aft = sb1.toString();
            list.add(o1);
        }
        Collections.sort(list, new Comparator<sortObj>() {
            @Override
            public int compare(sortObj o1, sortObj o2) {
                int o1int = Integer.valueOf(o1.aft).intValue();
                int o2int = Integer.valueOf(o2.aft).intValue();
                if(o1int != o2int){
                    return o1int-o2int;
                }
                else{
                    return o1.pos-o2.pos;
                }
            }
        });
        String[] results = new String[list.size()];
        for(int i = 0;i<list.size();i++){
            results[i] = list.get(i).ori;
        }
        return results;
    }


    //Q1 Strange Sorting
    public static String[] strangeSorting2(int[] m, String[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < m.length; i++)
            map.put(m[i],i);
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
                Boolean record = false;
                for(char c:o1.toCharArray()){
                    if(!record && map.get(c-'0')!= 0) record = true;
                    if(record) sb1.append(map.get(c-'0'));
                }
                record = false;
                for(char c:o2.toCharArray()){
                    if(!record && map.get(c-'0')!= 0) record = true;
                    if(record) sb2.append(map.get(c-'0'));
                }
                if(sb1.length()!= sb2.length()) return sb1.length()>sb2.length()? 1:-1;
                else return sb1.toString().compareTo(sb2.toString());
            }
        });
        return nums;
    }

    public static void main(String[] args) {
//        int[] map = new int[]{3,5,4,6,2,7,9,8,0,1};
//        String[] nums = new String[]{"990","32","332"};
//        String[] results = strangeSorting(map, nums);
//        System.out.println(Arrays.toString(results));


//        Scanner sc = new Scanner(System.in);
//        ArrayList<Integer> list = new ArrayList<>();
//        int lengthMapping = sc.nextInt();
//
//        int[] num = new int[lengthMapping];
//        for(int i=0;i<lengthMapping;i++){
//            num[i] = sc.nextInt();
//        }
//
//        int lengthInput = sc.nextInt();
//        String[] inputArr = new String[lengthInput];
//        for(int i=0;i<lengthInput;i++){
//            inputArr[i] = sc.next();
//        }
//        String[] results = strangeSorting2(num,inputArr);
//        System.out.println(Arrays.toString(results));


        //Q1
        //Testcase 1
        int mapping1[] = new int[]{3,5,4,6,2,7,9,8,0,1};
        String nums1[] = new String[]{"990","332","32"};
       // Testcase 2
        int mapping2[] = new int[]{2,1,4,8,6,3,0,9,7,5};
        String nums2[] = new String[]{"12","02","4","023","65","83","224","50"};
       // TestCase 3
        int mappin3[] = new int[]{0,1,2,3,4,5,6,7,8,9};
        String num3[] = new String[]{"180","84","99","003","53","28","60","070","1"};
        System.out.println(Arrays.asList(strangeSorting2(mapping1,nums1)));

    }


}


