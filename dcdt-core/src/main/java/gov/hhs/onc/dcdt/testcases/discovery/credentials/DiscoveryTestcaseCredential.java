package gov.hhs.onc.dcdt.testcases.discovery.credentials;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import gov.hhs.onc.dcdt.beans.ToolNamedBean;
import gov.hhs.onc.dcdt.beans.ToolOrderedBean;
import gov.hhs.onc.dcdt.collections.impl.AbstractToolPredicate;
import gov.hhs.onc.dcdt.crypto.credentials.CredentialConfig;
import gov.hhs.onc.dcdt.crypto.credentials.CredentialInfo;
import gov.hhs.onc.dcdt.crypto.crl.CrlConfig;
import gov.hhs.onc.dcdt.crypto.crl.CrlEntryConfig;
import gov.hhs.onc.dcdt.discovery.BindingType;
import gov.hhs.onc.dcdt.testcases.discovery.credentials.impl.DiscoveryTestcaseCredentialImpl;
import javax.annotation.Nullable;

@JsonSubTypes({ @Type(DiscoveryTestcaseCredentialImpl.class) })
public interface DiscoveryTestcaseCredential extends ToolNamedBean, ToolOrderedBean {
    public boolean hasBindingType();

    @JsonProperty("bindingType")
    @Nullable
    public BindingType getBindingType();

    public void setBindingType(@Nullable BindingType bindingType);

    public boolean hasCredentialConfig();

    @Nullable
    public CredentialConfig getCredentialConfig();

    public void setCredentialConfig(@Nullable CredentialConfig credConfig);

    public boolean hasCredentialInfo();

    @Nullable
    public CredentialInfo getCredentialInfo();

    public void setCredentialInfo(@Nullable CredentialInfo credInfo);

    public boolean hasCrlConfig();

    @Nullable
    public CrlConfig getCrlConfig();

    public void setCrlConfig(@Nullable CrlConfig crlConfig);

    public boolean hasCrlEntryConfig();

    @Nullable
    public CrlEntryConfig getCrlEntryConfig();

    public void setCrlEntryConfig(@Nullable CrlEntryConfig crlEntryConfig);

    public boolean hasDescription();

    @JsonProperty("desc")
    @Nullable
    public DiscoveryTestcaseCredentialDescription getDescription();

    public void setDescription(@Nullable DiscoveryTestcaseCredentialDescription desc);

    public boolean hasIssuerCredential();

    @JsonProperty("issuerCred")
    @Nullable
    public DiscoveryTestcaseCredential getIssuerCredential();

    public void setIssuerCredential(@Nullable DiscoveryTestcaseCredential issuerCred);

    public boolean hasLocation();

    @JsonProperty("loc")
    @Nullable
    public DiscoveryTestcaseCredentialLocation getLocation();

    public void setLocation(DiscoveryTestcaseCredentialLocation loc);

    public boolean hasType();

    @JsonProperty("type")
    @Nullable
    public DiscoveryTestcaseCredentialType getType();

    public void setType(@Nullable DiscoveryTestcaseCredentialType type);

    @JsonProperty("valid")
    public boolean isValid();

    public void setValid(boolean valid);
}
