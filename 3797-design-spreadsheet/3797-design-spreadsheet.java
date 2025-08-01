class Spreadsheet {
    int[][] sheet;
    public Spreadsheet(int rows) {
        sheet= new int[rows+1][26];
    }
    
    public void setCell(String cell, int value) {
        int col=cell.charAt(0)-'A';
        int row=Integer.parseInt(cell.substring(1,cell.length()));
        sheet[row][col]=value;
    }
    
    public void resetCell(String cell) {
        int col=cell.charAt(0)-'A';
        int row=Integer.parseInt(cell.substring(1,cell.length()));
        sheet[row][col]=0;
    }
    
    public int getValue(String formula) {
        formula = formula.split("=")[1];
        String[] cells= formula.split("\\+");
        int sum=0;
        for(String cell:cells){
            // System.out.println(cell+" ");
            // continue;
            if(cell.isEmpty()) continue;
            try{
                sum+=Integer.parseInt(cell);
            }
            catch(Exception e){
            int col=cell.charAt(0)-'A';
            int row=Integer.parseInt(cell.substring(1));
            sum+=sheet[row][col];
            }
        }
        return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */