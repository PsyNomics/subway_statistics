import org.apache.hadoop.io.Text;

public class SubwayPerformanceParser {
    private int totalGetOnNum = 0;
    private int totalGetOffNum = 0;
    // 역별 승하차 인원 총합
    // 첫 번째 줄 제외
    public SubwayPerformanceParser(Text text){
        try {
            String[] colums = text.toString().split(",");
            for(int i = 3; i < 50; i+=2){
                // 3 5 7 9 11 13 15 17 19 21 23 25 27 29 31 33 35 37 39 41 43 45 47 49
                totalGetOnNum += Integer.parseInt(colums[i]);
                totalGetOnNum += Integer.parseInt(colums[i+1]);
            }
        } catch (Exception e) {
            System.out.println("Error parsing a record" + e.getMessage());
        }
    }

    public int getTotalGetOnNum() {
        return totalGetOnNum;
    }

    public int getTotalGetOffNum() {
        return totalGetOffNum;
    }
}
