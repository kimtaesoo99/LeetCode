class Solution {
    public String destCity(List<List<String>> paths) {
        for (int i = 0; i < paths.size(); i++) {
            String s = paths.get(i).get(1);
            boolean pass = true;
            
            for (int j = 0; j < paths.size(); j++) {
                if (paths.get(j).get(0).equals(s)) {
                    pass = false;
                    break;
                }
            }

            if (pass) {
                return s;
            }
        }
        
        return "";
    }
}