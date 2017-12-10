import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * Created by kecso on 11/30/17.
 */
public class EmailDemo {

    public static void main(String[] args) {
        EmailDemo emailDemo = new EmailDemo("src/main/resources/email.properties");
//        EmailDemo emailDemo = new EmailDemo(args[0]);
//        emailDemo.sendEmail("kecso@oath.com", "sub", "body");

        Float f = 0.1F;
        System.out.println(1/f);

        long a = 100;
        long b = 33;
        long x = (a - b) / (a/100);
        System.out.println(x);

        Set<Integer> numset = new HashSet<Integer>();
        int[] nums2 = new int[numset.size()];
        Iterator<Integer> it = numset.iterator();
        int i = 0;
        while (it.hasNext()) {
            nums2[2] = it.next();
            i++;
        }
    }

    String emailConfigPath;
    private static Properties fMailServerConfig = new Properties();

    public EmailDemo(String emailConfigPath) {
        this.emailConfigPath = emailConfigPath;
        fetchConfig();
    }
    /**
     * Send a single email.
     */
    public void sendEmail(String aToEmailAddr, String aSubject, String aBody) {
        //Here, no Authenticator argument is used (it is null).
        //Authenticators are used to prompt the user for user
        //name and password.
        Session session = Session.getDefaultInstance(fMailServerConfig, null);
        MimeMessage message = new MimeMessage(session);
        try {
            //the "from" address may be set in code, or set in the
            //config file under "mail.from" ; here, the latter style is used
            //message.setFrom(new InternetAddress(aFromEmailAddr));
            message.addRecipient(
                    Message.RecipientType.TO, new InternetAddress(aToEmailAddr)
            );
            message.setSubject(aSubject);
            message.setText(aBody);
            Transport.send(message);
        } catch (MessagingException ex) {
            System.err.println("Cannot send email. " + ex);
        }
    }

    /**
     * Open a specific text file containing mail server
     * parameters, and populate a corresponding Properties object.
     */
    private void fetchConfig() {
        //This file contains the javax.mail config properties mentioned above.
        Path path = Paths.get(emailConfigPath);
        try (InputStream input = Files.newInputStream(path)) {
            fMailServerConfig.load(input);
            System.out.println(fMailServerConfig.toString());
        } catch (IOException ex) {
            System.err.println("Cannot open and load mail server properties file.");
        }
    }
}
