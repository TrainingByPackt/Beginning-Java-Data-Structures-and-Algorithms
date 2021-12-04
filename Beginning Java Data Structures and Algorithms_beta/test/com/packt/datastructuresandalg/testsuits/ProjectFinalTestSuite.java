package com.packt.datastructuresandalg.testsuits;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectPackages({"com.packt.datastructuresandalg.project.finalbonus",
	"com.packt.datastructuresandalg.project.finalbonus.extra"})
public class ProjectFinalTestSuite {

}