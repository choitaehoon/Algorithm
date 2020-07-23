package kakao.blind2019;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//테스트 케이스 점검하기
public class 매칭점수 {

    static Map<String, WebPage> webPageInfo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(solution(
                "Muzi", new String[]{
                        "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                                "<head>\n" +
                                "  <meta charset=\"utf-8\">\n" +
                                "  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n" +
                                "</head>  \n" +
                                "<body>\n" +
                                "<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n" +
                                "\n" +
                                "</body>\n" +
                                "</html>",
                        "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                                "<head>\n" +
                                "  <meta charset=\"utf-8\">\n" +
                                "  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n" +
                                "</head>  \n" +
                                "<body>\n" +
                                "con%    muzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n" +
                                "\n" +
                                "    ^\n" +
                                "</body>\n" +
                                "</html>"
                }
        ));
    }

    public static int solution(String word, String[] pages) {
        int pageLength = pages.length;

        for (int i = 0; i < pageLength; ++i) {
            link(i, word, pages[i]);
        }

        Map<String, ResultWebPage> result = new HashMap<>();
        for (Map.Entry<String, WebPage> test : webPageInfo.entrySet()) {
            String key = test.getKey();
            WebPage value = test.getValue();
            int index = value.index;
            double defaultSum = value.defaultSum;
            double outLinkSum = value.outLinkSum;
            List<String> outLink = value.outLink;

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < outLink.size(); ++i) {
                double sum = 0.0;
                builder.append(outLink.get(i)).append(" ");

                if (webPageInfo.containsKey(webPageInfo.get(outLink.get(i)))) {
                    WebPage webPage = webPageInfo.get(outLink.get(i));
                    if (webPage.outLinkSum != 0.0)
                        sum += defaultSum / outLinkSum;

                    result.put(outLink.get(i), result.get(outLink.get(i)) == null ?
                            new ResultWebPage(webPageInfo.get(outLink.get(i)).index, sum) :
                            new ResultWebPage(webPageInfo.get(outLink.get(i)).index, result.get(outLink.get(i)).sum + sum));
                }
            }

            result.put(key, result.get(key) == null ?
                    new ResultWebPage(index, defaultSum) :
                    new ResultWebPage(index, result.get(key).sum + defaultSum));

        }

        List<Map.Entry<String, ResultWebPage>> listResultWeb = new ArrayList<>(result.entrySet());
        listResultWeb.sort((a1, a2) -> {
            int r = Double.compare(a2.getValue().sum,  a1.getValue().sum);

            if (r != 0) return r;

            return a1.getValue().index - a2.getValue().index;
        });

        return listResultWeb.get(0).getValue().index;
    }

    private static void link(int index, String word, String page) {
        String regex = "<meta property=\"og:url\" content=\"https://(?<url>[^\"]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(page);

        String webName = "";
        while (matcher.find()) {
            webName = matcher.group("url");
        }

        int defaultSum = wordCount(word, page);
        List<String> outLinkStore = outLink(page);
        webPageInfo.put(webName, new WebPage(index, defaultSum, outLinkStore.size(), outLinkStore));
    }

    private static List<String> outLink(String page) {
        String regex = "<a href=\"https://(?<link>[^\"]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(page);

        List<String> outLink = new ArrayList<>();
        while (matcher.find())
            outLink.add(matcher.group("link"));

        return outLink;
    }

    private static int wordCount(String word, String page) {
        String[] wordArray = page.split("[^a-zA-Z]");
        int count = 0;

        for (String s : wordArray) {
            if (word.equalsIgnoreCase(s))
                ++count;
        }

        return count;
    }

}

class WebPage {

    int index;
    double defaultSum;
    double outLinkSum;
    List<String> outLink;

    public WebPage (int index, double defaultSum, double outLinkSum, List<String> outLink) {
        this.index = index;
        this.defaultSum = defaultSum;
        this.outLinkSum = outLinkSum;
        this.outLink = outLink;
    }

}

class ResultWebPage {

    int index;
    double sum;

    public ResultWebPage(int index, double sum) {
        this.index = index;
        this.sum = sum;
    }

}
