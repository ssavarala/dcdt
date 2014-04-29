package gov.hhs.onc.dcdt.discovery.steps.impl;

import gov.hhs.onc.dcdt.crypto.certs.CertificateInfo;
import gov.hhs.onc.dcdt.crypto.certs.CertificateInfoValidator;
import gov.hhs.onc.dcdt.discovery.BindingType;
import gov.hhs.onc.dcdt.discovery.steps.CertificateDiscoveryStep;
import gov.hhs.onc.dcdt.discovery.steps.CertificateLookupStep;
import gov.hhs.onc.dcdt.discovery.steps.CertificateValidationStep;
import gov.hhs.onc.dcdt.mail.MailAddress;
import gov.hhs.onc.dcdt.utils.ToolCollectionUtils;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;

public class CertificateValidationStepImpl extends AbstractCertificateDiscoveryStep implements CertificateValidationStep {
    @Autowired
    private CertificateInfoValidator certInfoValidator;

    private CertificateInfo validCertInfo;

    public CertificateValidationStepImpl() {
        super(BindingType.NONE);
    }

    @Override
    public boolean execute(List<CertificateDiscoveryStep> prevSteps, MailAddress directAddr) {
        CertificateLookupStep<?, ?, ?, ?> certLookupStep = ToolCollectionUtils.findAssignable(CertificateLookupStep.class, prevSteps);

        // noinspection ConstantConditions
        if (certLookupStep.isSuccess() && certLookupStep.hasCertificateInfos()) {
            Pair<Boolean, List<String>> certInfoValidationResultPair;

            // noinspection ConstantConditions
            for (CertificateInfo certInfo : certLookupStep.getCertificateInfos()) {
                this.execMsgs.addAll((certInfoValidationResultPair = this.certInfoValidator.validate(directAddr, certInfo)).getRight());

                if (certInfoValidationResultPair.getLeft()) {
                    this.validCertInfo = certInfo;

                    break;
                }
            }
        }

        return this.isSuccess();
    }

    @Override
    public boolean isSuccess() {
        return (super.isSuccess() && this.hasValidCertificateInfo());
    }

    @Override
    public boolean hasValidCertificateInfo() {
        return (this.validCertInfo != null);
    }

    @Nullable
    @Override
    public CertificateInfo getValidCertificateInfo() {
        return this.validCertInfo;
    }
}