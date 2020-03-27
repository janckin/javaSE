package leetcode.code;

public class LongestCommonPrefix {
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // repeat context
        StringBuffer strBuff = new StringBuffer();

        // compare
        String firstStr = strs[0];
        int strsLen = strs.length;

        try {
            for (int i = 0; i < firstStr.length(); i++) {
                // basic the first word
                char firstChar = firstStr.charAt(i);
                char nextChar;
                boolean isDiff = false;
                for (int j = 1; j < strsLen; j++) {
                    // compare other string in strs
                    String str = strs[j];
                    nextChar = str.charAt(i);
                    if (firstChar != nextChar) {
                        isDiff = true;
                        break;
                    }
                }
                if (isDiff) {
                    break;
                } else {
                    strBuff.append(firstChar);
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("firstStr is not the smallest!");
        }
        String rs = strBuff.toString();
        return rs;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < prefix.length(); i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
