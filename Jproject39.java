private int map(int blockNO) {
        int rowNO = -1;
        int SetsBit = (int)(Math.log(SETS)/Math.log(2));
        int taglen = 22 - SetsBit;
        int setTh = (int) (blockNO % Math.pow(2,SetsBit));
        String binBlockNO = transformer.intToBinary(String.valueOf(blockNO));
        String tag = binBlockNO.substring(10,10+taglen);
        int lineTh = setTh * setSize;
        for (int ptr=lineTh; ptr<lineTh+setSize; ptr++){
            if (new String(cache.get(ptr).getTag()).substring(0,taglen).equals(tag)){
                rowNO = ptr; //
                break;
            }
        }
        return rowNO;
//        int setNO = blockNO%SETS;           // 获得内存地址blockNO所对应的组号setNO
//        char[] addrTag = getTag( blockNO );   // 获得内存地址blockNO所对应的tag
//        return this.replacementStrategy.hit( setNO*setSize, (setNO+1)*setSize-1, addrTag );
    }
