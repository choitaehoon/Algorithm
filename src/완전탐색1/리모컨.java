package 완전탐색1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("all")
public class 리모컨 {

    static boolean [] check = new boolean[10];
    static int givenChannel;
    static int brokenButton;
    static int givenChannelMinusHundred;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        givenChannel = Integer.parseInt(buffer.readLine());
        brokenButton = Integer.parseInt(buffer.readLine());
        StringTokenizer token = new StringTokenizer(buffer.readLine());

        givenChannelMinusHundred = Math.abs(givenChannel - 100);

        //고장난 버튼 true로 받기
        while (token.hasMoreTokens())
            check[Integer.parseInt(token.nextToken())] = true;

        System.out.println(getMinButtonGo());
    }

    private static int getMinButtonGo() {

        for (int i=0; i<1000000; ++i){
            int channel = i;
            int allowLength = numberCalculate(channel);
            int givenChannelMinusNowChannel = Math.abs(givenChannel - channel);

            if (allowLength == 0)
                continue;

            if (givenChannelMinusHundred > allowLength + givenChannelMinusNowChannel)
                givenChannelMinusHundred = allowLength + givenChannelMinusNowChannel;

        }

        return givenChannelMinusHundred;
    }

    private static int numberCalculate(int channel) {
        int channelLength = 0;

        if (channel == 0)
            return check[0] ? 0 : 1;

        while (channel > 0) {
            if (check[channel%10])
                //0을 반환한다는 것은 이 채널을 만들 수 없다는 것
                return 0;
            channelLength++;
            channel /= 10;
        }

        return channelLength;
    }

}
