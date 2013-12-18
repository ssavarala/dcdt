package gov.hhs.onc.dcdt.web.mail.decrypt;

import gov.hhs.onc.dcdt.beans.testcases.TestcaseResultStatus;
import gov.hhs.onc.dcdt.beans.testcases.discovery.DiscoveryTestcase;
import gov.hhs.onc.dcdt.beans.testcases.discovery.DiscoveryTestcaseResult;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 * Bean for email information including to/from addresses, file location of
 * email, the test case value, and the results of the email decryption.
 * 
 * @author jasonsmith
 * @author michal.kotelba@esacinc.com
 */
public class EmailBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private File file;
	private Date received;
	private String toAddress;
	private String fromAddress;
	private DiscoveryTestcase testcase;
	private DiscoveryTestcaseResult result;
	private TestcaseResultStatus resultStatus;
	private String resultMsg;

	public EmailBean()
	{
		this(null);
	}
	
	public EmailBean(File file)
	{
		this.file = file;
	}

	public File getFile()
	{
		return this.file;
	}

	public void setFile(File file)
	{
		this.file = file;
	}

	public String getFromAddress()
	{
		return this.fromAddress;
	}

	public void setFromAddress(String fromAddress)
	{
		this.fromAddress = fromAddress;
	}

	public Date getReceived()
	{
		return this.received;
	}

	public void setReceived(Date received)
	{
		this.received = received;
	}

	public DiscoveryTestcaseResult getResult()
	{
		return this.result;
	}

	public void setResult(DiscoveryTestcaseResult result)
	{
		this.result = result;
	}

	public String getResultMsg()
	{
		return this.resultMsg;
	}

	public void setResultMsg(String resultMsg)
	{
		this.resultMsg = resultMsg;
	}

	public TestcaseResultStatus getResultStatus()
	{
		return this.resultStatus;
	}

	public void setResultStatus(TestcaseResultStatus resultStatus)
	{
		this.resultStatus = resultStatus;
	}

	public DiscoveryTestcase getTestcase()
	{
		return this.testcase;
	}

	public void setTestcase(DiscoveryTestcase testcase)
	{
		this.testcase = testcase;
	}

	public String getToAddress()
	{
		return this.toAddress;
	}

	public void setToAddress(String toAddress)
	{
		this.toAddress = toAddress;
	}
}