import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to convert an XML RSS (version 2.0) feed from a given URL into the
 * corresponding HTML output file.
 *
 * @author Tony Han
 *
 */
public final class RSSAggregator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private RSSAggregator() {
    }

    /**
     * Outputs the "opening" tags in the generated HTML file. These are the
     * expected elements generated by this method:
     *
     * <html> <head> <title>the channel tag title as the page title</title>
     * </head> <body>
     * <h1>the page title inside a link to the <channel> link</h1>
     * <p>
     * the channel description
     * </p>
     * <table border="1">
     * <tr>
     * <th>Date</th>
     * <th>Source</th>
     * <th>News</th>
     * </tr>
     *
     * @param channel
     *            the channel element XMLTree
     * @param out
     *            the output stream
     * @updates out.content
     * @requires [the root of channel is a <channel> tag] and out.is_open
     * @ensures out.content = #out.content * [the HTML "opening" tags]
     */
    private static void outputHeader(XMLTree channel, SimpleWriter out) {
        assert channel != null : "Violation of: channel is not null";
        assert out != null : "Violation of: out is not null";
        assert channel.isTag() && channel.label().equals("channel") : ""
                + "Violation of: the label root of channel is a <channel> tag";
        assert out.isOpen() : "Violation of: out.is_open";

        /*
         * TODO: fill in body
         */
        String pageTitle;
        String description;
        int titleNum = getChildElement(channel, "title");
        int descriptionNum = getChildElement(channel, "description");
        if (titleNum != -1) {
            if (channel.child(titleNum).numberOfChildren() > 0) {
                pageTitle = channel.child(getChildElement(channel, "title"))
                        .child(0).label();
            } else {
                pageTitle = "Empty Title";
            }
        } else {
            pageTitle = "Empty Title";
        }

        if (descriptionNum != -1) {
            if (channel.child(descriptionNum).numberOfChildren() > 0) {
                description = channel
                        .child(getChildElement(channel, "description")).child(0)
                        .label();
            } else {
                description = "No description";
            }
        } else {
            description = "No description";
        }

        out.println("<html>");
        out.println("<head>");
        out.println("<title>" + pageTitle + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(
                "<h1><a href="
                        + channel.child(getChildElement(channel, "link"))
                                .child(0).label()
                        + ">" + pageTitle + "</a></h1>");
        out.println("<p>" + description + "</p>");
        out.println("<table border=\"1\">");
        out.println("<tr>");
        out.println("<th>Date</th>");
        out.println("<th>Source</th>");
        out.println("<th>News</th>");
        out.println("</tr>");

    }

    /**
     * Outputs the "closing" tags in the generated HTML file. These are the
     * expected elements generated by this method:
     *
     * </table>
     * </body> </html>
     *
     * @param out
     *            the output stream
     * @updates out.contents
     * @requires out.is_open
     * @ensures out.content = #out.content * [the HTML "closing" tags]
     */
    private static void outputFooter(SimpleWriter out) {
        assert out != null : "Violation of: out is not null";
        assert out.isOpen() : "Violation of: out.is_open";

        /*
         * TODO: fill in body
         */
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Finds the first occurrence of the given tag among the children of the
     * given {@code XMLTree} and return its index; returns -1 if not found.
     *
     * @param xml
     *            the {@code XMLTree} to search
     * @param tag
     *            the tag to look for
     * @return the index of the first child of type tag of the {@code XMLTree}
     *         or -1 if not found
     * @requires [the label of the root of xml is a tag]
     * @ensures <pre>
     * getChildElement =
     *  [the index of the first child of type tag of the {@code XMLTree} or
     *   -1 if not found]
     * </pre>
     */
    private static int getChildElement(XMLTree xml, String tag) {
        assert xml != null : "Violation of: xml is not null";
        assert tag != null : "Violation of: tag is not null";
        assert xml.isTag() : "Violation of: the label root of xml is a tag";

        /*
         * TODO: fill in body
         */
        int tagNum = -1;
        for (int i = 0; i < xml.numberOfChildren() && tagNum == -1; i++) { //traversing all children to find tag needed
            if (xml.child(i).label() == tag) {
                tagNum = i;
            }
        }
        return tagNum;
    }

    /**
     * Processes one news item and outputs one table row. The row contains three
     * elements: the publication date, the source, and the title (or
     * description) of the item.
     *
     * @param item
     *            the news item
     * @param out
     *            the output stream
     * @updates out.content
     * @requires [the label of the root of item is an <item> tag] and
     *           out.is_open
     * @ensures <pre>
     * out.content = #out.content *
     *   [an HTML table row with publication date, source, and title of news item]
     * </pre>
     */
    private static void processItem(XMLTree item, SimpleWriter out) {
        assert item != null : "Violation of: item is not null";
        assert out != null : "Violation of: out is not null";
        assert item.isTag() && item.label().equals("item") : ""
                + "Violation of: the label root of item is an <item> tag";
        assert out.isOpen() : "Violation of: out.is_open";

        /*
         * TODO: fill in body
         */
        out.println("<tr>");

        String pubDate = "";
        String source = "";
        String sourceLink = "";
        String title = "";
        String link = "";
        String description = "";
        boolean hasSource = false;
        boolean hasPubDate = false;
        boolean hasTitle = false;
        boolean hasLink = false;

        int pubDateNum = getChildElement(item, "pubDate");
        int sourceNum = getChildElement(item, "source");
        int titleNum = getChildElement(item, "title");
        int linkNum = getChildElement(item, "link");
        int descriptionNum = getChildElement(item, "description");

        if (pubDateNum != -1) {
            pubDate = item.child(pubDateNum).child(0).label();
            out.println("<td>" + pubDate + "</td>");
        } else {
            out.println("<td>No data available</td>");
        }
        if (sourceNum != -1) {
            if (item.child(sourceNum).numberOfChildren() > 0) {
                source = item.child(sourceNum).child(0).label();
            } else {
                source = "No source available";
            }
            sourceLink = item.child(sourceNum).attributeValue("url");
            out.println(
                    "<td><a href=" + sourceLink + ">" + source + "</a></td>");
        } else {
            out.println("<td>No source available</td>");
        }
        if (titleNum != -1) {
            if (item.child(titleNum).numberOfChildren() > 0) {
                title = item.child(titleNum).child(0).label();
            } else {
                description = item.child(descriptionNum).child(0).label();
                out.println("<td>" + description + "</td>");
            }
            if (linkNum != -1) {
                link = item.child(linkNum).child(0).label();
                out.println("<td><a href=" + link + ">" + title + "</a></td>");
            } else {
                out.println("<td>" + title + "</td>");
            }
        } else {
            description = item.child(descriptionNum).child(0).label();
            out.println("<td>" + description + "</td>");
        }

        /*
         * for (int i = 0; i < item.numberOfChildren(); i++) { if
         * (item.child(i).label().equals("pubDate")) { //check if publication
         * date is available pubDate = item.child(i).child(0).label();
         * hasPubDate = true; } if (item.child(i).label().equals("source")) {
         * //check if source is available source =
         * item.child(i).child(0).label(); sourceLink =
         * item.child(i).attributeValue("url"); hasSource = true; } if
         * (item.child(i).label().equals("title")) { //check if title is
         * available title = item.child(i).child(0).label(); hasTitle = true; }
         * if (item.child(i).label().equals("link")) { //check if link is
         * available link = item.child(i).child(0).label(); hasLink = true; }
         *
         * } if (!hasPubDate) { out.println("<td>No data available</td>"); }
         * else { out.println("<td>" + pubDate + "</td>"); } if (!hasSource) {
         * out.println("<td>No source available</td>"); } else { out.println(
         * "<td><a href=" + sourceLink + ">" + source + "</a></td>"); } if
         * (!hasTitle) { out.println("<td>No title available</td>"); } else if
         * (!hasLink) { out.println("<td>" + title + "</td>"); } else {
         * out.println("<td><a href=" + link + ">" + title + "</a></td>"); }
         */

        out.println("</tr>");
    }

    /**
     * Processes one XML RSS (version 2.0) feed from a given URL converting it
     * into the corresponding HTML output file.
     *
     * @param url
     *            the URL of the RSS feed
     * @param file
     *            the name of the HTML output file
     * @param out
     *            the output stream to report progress or errors
     * @updates out.content
     * @requires out.is_open
     * @ensures <pre>
     * [reads RSS feed from url, saves HTML document with table of news items
     *   to file, appends to out.content any needed messages]
     * </pre>
     */
    private static void processFeed(String url, String file, SimpleWriter out) {
        boolean valid = true;
        XMLTree xml = new XMLTree1(url);
        xml.display();
        while (!xml.label().equals("rss") && !xml.hasAttribute("version")
                && !xml.attributeValue("version").equals("2.0")) {
            out.print("Invalid RSS feed.");
            valid = false;
        }
        if (valid) {
            xml = new XMLTree1(url);
            XMLTree channel = xml.child(getChildElement(xml, "channel"));
            SimpleWriter PrintToFile = new SimpleWriter1L(file);
            outputHeader(channel, PrintToFile);
            for (int i = 0; i < channel.numberOfChildren(); i++) {
                if (channel.child(i).label().equals("item")) {
                    processItem(channel.child(i), PrintToFile);
                }
            }
            outputFooter(PrintToFile);
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        /*
         * TODO: fill in body
         */
        out.print("Please enter the xml adress:");
        String xmlFileName = in.nextLine();
        out.print("Please enter the html file name:");
        String htmlFileName = in.nextLine();
        XMLTree xml = new XMLTree1(xmlFileName);
        SimpleWriter PrintHTML = new SimpleWriter1L(htmlFileName);
        if (xml.hasAttribute("title")) {
            PrintHTML.println("<html><head><title>"
                    + xml.attributeValue("title") + "</title></head>");
        }
        PrintHTML.println("<body><h2>" + xml.attributeValue("title") + "</h2>");
        PrintHTML.println("<ul>");
        for (int i = 0; i < xml.numberOfChildren(); i++) {

            processFeed(xml.child(i).attributeValue("url"),
                    xml.child(i).attributeValue("file"), out);
            PrintHTML.println("<li><a href="
                    + xml.child(i).attributeValue("file") + ">"
                    + xml.child(i).attributeValue("name") + "</a></li>");
        }
        PrintHTML.println("</ul></body></html>");
        in.close();
        out.close();
    }

}