/**
 * Created by kecso on 3/31/17.
 */

import org.apache.commons.math3.util.Precision;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class A
{
    public static void yahoo(int kingX, int kingY, int Ex, int Ey){
        Queue<Node> q = new LinkedList<>();
        Node King = new Node(kingX,kingY);
        HashSet<Node> visited = new HashSet<>();
        q.offer(King);
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Node node = q.poll();
                if(node.x == Ex && node.y == Ey){
                    System.out.println(res);
                }
                visited.add(node);
                node.n();
                for(int i = 0; i < 8; i++){
                    q.offer(node.neighbor[i]);
                }
            }
            res++;
        }
    }
    public static void main (String[] args) throws java.lang.Exception {
        long a = 14555243522L;
        long b = 245553453L;
        float ab = Precision.round((((float)b)/a)*100, 1);
//        float ab = (((float)b*100)/a);
        System.out.println(ab);

        List exclusionReportWFMetrics = new ArrayList<>();

        exclusionReportWFMetrics.add("SeatAGSiteExclusion");
        exclusionReportWFMetrics.add("SeatAGAppExclusion");
        exclusionReportWFMetrics.add("CreativeNotAudit");
        exclusionReportWFMetrics.add("CreativeNotSecure");
        exclusionReportWFMetrics.add("VideoVastAndWrapper");
        exclusionReportWFMetrics.add("VideoDuration");
        exclusionReportWFMetrics.add("VideoCreativeMedia");
        exclusionReportWFMetrics.add("VideoViewabilityOrPlayerSize");
        exclusionReportWFMetrics.add("AdPosition");
        exclusionReportWFMetrics.add("SiteAppExclusion");
        // needed but not available
//        exclusionReportWFMetrics.add("GdprPreciseGeo");
        // from index
//        exclusionReportWFMetrics.add("GeoLocation");
        exclusionReportWFMetrics.add("LocationFile");
        // are contextuals from index?
        exclusionReportWFMetrics.add("ContextualCategory");
        // from index
//        exclusionReportWFMetrics.add("DeviceBrowser");
//        exclusionReportWFMetrics.add("CreativeNotIOS9Compliant");
        // from index
//        exclusionReportWFMetrics.add("MobileMakeModel");
//        exclusionReportWFMetrics.add("CTVDeviceTargeting");
        exclusionReportWFMetrics.add("Carrier");
        exclusionReportWFMetrics.add("ConnectionType");
        exclusionReportWFMetrics.add("ISP");
        exclusionReportWFMetrics.add("DayParting");
        exclusionReportWFMetrics.add("Bot");
        // needed but not available
//        exclusionReportWFMetrics.add("TrafficQualityVendor");
        exclusionReportWFMetrics.add("InventoryType");
        exclusionReportWFMetrics.add("UserDemorgraphic");
        exclusionReportWFMetrics.add("LineFrequency");
        // is this indexing?
        exclusionReportWFMetrics.add("ExcludedBeacon");
        // from index
//        exclusionReportWFMetrics.add("ExcludedSegment");
        // from index
//        exclusionReportWFMetrics.add("UserSegment");
        exclusionReportWFMetrics.add("IOFrequency");
        exclusionReportWFMetrics.add("RtbSeat");
        exclusionReportWFMetrics.add("InViewDecisionHard");
        exclusionReportWFMetrics.add("InViewDecisionSoft");
        exclusionReportWFMetrics.add("GroupMDecisionHard");
        exclusionReportWFMetrics.add("GroupMDecisionSoft");
        exclusionReportWFMetrics.add("AvocDecisionHard");
        exclusionReportWFMetrics.add("AvocDecisionSoft");
        exclusionReportWFMetrics.add("VideoCompletionDecisionHard");
        exclusionReportWFMetrics.add("VideoCompletionDecisionSoft");
        exclusionReportWFMetrics.add("CTRDecisionSoft");
        exclusionReportWFMetrics.add("CreativeThrottling");
        // needed but not available
//        exclusionReportWFMetrics.add("BidFeedbackThrottling");
        exclusionReportWFMetrics.add("NegativeROI");
        exclusionReportWFMetrics.add("FilterDupBid");
        exclusionReportWFMetrics.add("CreativeFreqExclusion");
        exclusionReportWFMetrics.add("Inclusion");

        System.out.println(exclusionReportWFMetrics.size());
        System.out.println(exclusionReportWFMetrics.toString());
        
//        yahoo(3,3,5,5);

    }
}


class Node{
    int x;
    int y;
    int[] xAxis = new int[]{1,1,1,0,0,-1,-1,-1};
    int[] yAxis = new int[]{0,1,-1,1,-1,1,0,-1};
    public Node[] neighbor = new Node[8];
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void n() {
        for(int i = 0; i < 8; i++){
            neighbor[i] = new Node(x + xAxis[i], y + yAxis[i]);
        }
    }
}
