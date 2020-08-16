package jenkins;

import Jenkins.JenkinsClient;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JenkinsClientTest {

    @Test
    public void testJenkinsClientUrl() {
        String jenkinsUrl = "http://localhost:9099/jenkins";
        JenkinsClient client = new JenkinsClient(jenkinsUrl);
        Assert.assertEquals(client.getJenkinsURL(), jenkinsUrl);
    }


}
