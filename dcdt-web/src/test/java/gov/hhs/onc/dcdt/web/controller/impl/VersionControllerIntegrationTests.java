package gov.hhs.onc.dcdt.web.controller.impl;

import gov.hhs.onc.dcdt.web.test.ControllerTests;
import gov.hhs.onc.dcdt.web.test.impl.AbstractToolControllerIntegrationTests;
import org.testng.annotations.Test;

@ControllerTests(titleMessageCode = ControllerTests.MSG_CODE_TITLE_PREFIX + "version", url = "/version")
@Test(dependsOnGroups = { "dcdt.test.it.web.controller.home" }, groups = { "dcdt.test.it.web.controller.version" })
public class VersionControllerIntegrationTests extends AbstractToolControllerIntegrationTests {
}
