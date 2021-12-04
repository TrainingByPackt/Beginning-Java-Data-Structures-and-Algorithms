package com.packt.datastructuresandalg.lesson5.activity.project.test.bonus;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.packt.datastructuresandalg.lesson5.activity.project.bonus.SentenceSearch;

class SentenceSearchTest {

	public static String file = "There is archaeological evidence of human occupation of the Rome area from approximately 14,000 years ago, but the dense layer of much younger debris obscures Palaeolithic and Neolithic sites. Evidence of stone tools, pottery, and stone weapons attest to about 10,000 years of human presence. Several excavations support the view that Rome grew from pastoral settlements on the Palatine Hill built above the area of the future Roman Forum. Between the end of the bronze age and the beginning of the Iron age, each hill between the sea and the Capitol was topped by a village (on the Capitol Hill, a village is attested since the end of the 14th century BC). However, none of them had yet an urban quality. Nowadays, there is a wide consensus that the city developed gradually through the aggregation (\"synoecism\") of several villages around the largest one, placed above the Palatine. This aggregation was facilitated by the increase of agricultural productivity above the subsistence level, which also allowed the establishment of secondary and tertiary activities. These in turn boosted the development of trade with the Greek colonies of southern Italy (mainly Ischia and Cumae). These developments, which according to archaeological evidence took place during the mid-eighth century BC, can be considered as the \"birth\" of the city. Despite recent excavations at the Palatine hill, the view that Rome was founded deliberately in the middle of the eighth century BC, as the legend of Romulus suggests, remains a fringe hypothesis.\r\n" + 
			"Traditional stories handed down by the ancient Romans themselves explain the earliest history of their city in terms of legend and myth. The most familiar of these myths, and perhaps the most famous of all Roman myths, is the story of Romulus and Remus, the twins who were suckled by a she-wolf. They decided to build a city, but after an argument, Romulus killed his brother and the city took his name. According to the Roman annalists, this happened on 21 April 753 BC. This legend had to be reconciled with a dual tradition, set earlier in time, that had the Trojan refugee Aeneas escape to Italy and found the line of Romans through his son Iulus, the namesake of the Julio-Claudian dynasty. This was accomplished by the Roman poet Virgil in the first century BC.\r\n" + 
			"After the legendary foundation by Romulus, Rome was ruled for a period of 244 years by a monarchical system, initially with sovereigns of Latin and Sabine origin, later by Etruscan kings. The tradition handed down seven kings: Romulus, Numa Pompilius, Tullus Hostilius, Ancus Marcius, Tarquinius Priscus, Servius Tullius and Tarquinius Superbus.\r\n" + 
			"The Ancient-Imperial-Roman palaces of the Palatine are a series of palaces located in the Palatine Hill visibly express the power and wealth of emperors from Augustus until the 4th century.\r\n" + 
			"In 509 BC, the Romans expelled the last king from their city and established an oligarchic republic. Rome then began a period characterized by internal struggles between patricians (aristocrats) and plebeians (small landowners), and by constant warfare against the populations of central Italy: Etruscans, Latins, Volsci, Aequi, Marsi. After becoming master of Latium, Rome led several wars (against the Gauls, Osci-Samnites and the Greek colony of Taranto, allied with Pyrrhus, king of Epirus) whose result was the conquest of the Italian peninsula, from the central area up to Magna Graecia.\r\n" + 
			"The third and second century BC saw the establishment of Roman hegemony over the Mediterranean and the East, through the three Punic Wars (264–146 BC) fought against the city of Carthage and the three Macedonian Wars (212–168 BC) against Macedonia. Then were established the first Roman provinces: Sicily, Sardinia and Corsica, Hispania, Macedonia, Achaea and Africa.\r\n" + 
			"\r\n" + 
			"From the beginning of the 2nd century BC, power was contested between two groups of aristocrats: the optimates, representing the conservative part of the Senate, and the populares, which relied on the help of the plebs (urban lower class) to gain power. In the same period, the bankruptcy of the small farmers and the establishment of large slave estates provoked the migration to the city of a large number of people. The continuous warfare made necessary a professional army, which was more loyal to its generals than to the republic. Because of this, in the second half of the second century and during the first century BC there were conflicts both abroad and internally: after the failed attempt of social reform of the populares Tiberius and Gaius Gracchus, and the war against Jugurtha, there was a first civil war between Gaius Marius and Sulla. To this followed a major slave revolt under Spartacus, and then the establishment of the first Triumvirate with Caesar, Pompey and Crassus.\r\n" + 
			"The conquest of Gaul made Caesar immensely powerful and popular, which led to a second civil war against the Senate and Pompey. After his victory, Caesar established himself as dictator for life. His assassination led to a second Triumvirate among Octavian (Caesar's grandnephew and heir), Mark Antony and Lepidus, and to another civil war between Octavian and Antony. The former in 27 BC became princeps civitatis and got the title of Augustus, founding the principate, a diarchy between the princeps and the senate. Rome was established as a de facto empire, which reached its greatest expansion in the second century under the Emperor Trajan. Rome was confirmed as caput Mundi, i.e. the capital of the world, an expression which had already been given in the Republican period. During its first two centuries, the empire saw as rulers, emperors of the Julio-Claudian, Flavian (who also built eponymous amphitheatre, known as the Colosseum) and Antonine dynasties. This time was also characterised by the spread of the Christian religion, preached by Jesus Christ in Judea in the first half of the first century (under Tiberius) and popularized by his apostles through the empire and beyond. The Antonine age is considered the apogee of the Empire, whose territory ranged from the Atlantic Ocean to the Euphrates and from Britain to Egypt.\r\n" + 
			"After the end of the Severan Dynasty in 235, the Empire entered into 50-year period known as the Crisis of the Third Century during which there were numerous putsches by generals, who sought to secure the region of the empire they were entrusted with due to the weakness of central authority in Rome. There was the so-called Gallic Empire from 260-274 and the revolts of Zenobia and her father from the mid-260s which sought to fend off Persian incursions. Some regions – Britain, Spain, and North Africa – were hardly affected. Instability caused economic deterioration, and there was a rapid rise in inflation as the government debased the currency in order to meet expenses. The Germanic tribes along the Rhine and north of the Balkans made serious, uncoordinated incursions from the 250s-280s that were more like giant raiding parties rather than attempts to settle. The Persian Empire in the East invaded several times during the 230s to 260s but were eventually defeated. Emperor Diocletian (284) undertook the restoration of the State. He ended the Principate and introduced the so-called dominate which tried to give the impression of absolute power. The most marked feature was the unprecedented intervention of the State down to the city level: whereas the State had submitted a tax demand to a city and allowed it to allocate the charges, from his reign the State did this down to the village level. In a vain attempt to control inflation, he imposed price controls which did not last. He or Constantine regionalized the administration of the empire which fundamentally changed the way it was governed by creating regional dioceses (the consensus seems to have shifted from 297 to 313/14 as the date of creation due to the argument of Constantin Zuckerman in 2002 \"Sur la liste de Verone et la province de grande armenie, Melanges Gilber Dagron). The existence of regional fiscal units from 286 served as the model for this unprecedented innovation. The emperor quickened the process of removing military command from governors. Henceforth, civilian administration and military command would be separate. He gave governors more fiscal duties and placed them in charge of the army logistical support system as an attempt to control it by removing the support system from its control. Diocletian ruled the eastern half (with residence in Nicomedia). In 296, he elevated Maximian as Augustus of the western half where he ruled mostly from Mediolanum (Current day Milan) when not on the move. In 292, he created two 'junior' emperors, the Caesars, one for each Augustus, Constantius for Britain, Gaul, and Spain whose seat of power was in Trier and Licinius in Srimium in the Balkans. The appointment of a Caesar was not unknown: Diocletian tried to turn into a system of non-dynastic succession. Upon abdication in 305, Caesars succeeded and they in turn appointed to colleagues for themselves.\r\n" + 
			"After the abdication of Diocletian and Maximian in 305 and a series of civil wars between rival claimants to imperial power during the years 306–313, the Tetrarchy was abandoned. Constantine called the Great undertook a major reform of the bureaucracy not by changing the structure but by rationalizing the competencies of the several ministries during the years 325–330 after he defeated Licinius, emperor in the East at the end of 324.The so-called Edict of Milan of 313, actually a fragment of a Letter from Licinius to the governors of the eastern provinces, granted freedom of worship to everyone including to Christians and ordered the restoration of confiscated church properties upon petition to the newly created vicars of dioceses. He funded the building of several churches and allowed clergy to act as arbitrators in civil suits (a measure that did not outlast him but which was restored in part much later). He transformed the town of Byzantium into his new residence, which however, was not officially anything more than an imperial residence like Milan or Trier or Nicomedia until given a city prefect in May 359 by Constantius II; Constantinople. The creation of Constantinople would have a profound effect on Europe: it was the bulwark against invasion and conquest from the East for 1000 years.\r\n" + 
			"Christianity in the form of the Nicene Creed became the official religion of the empire in 380 via the Edict of Thessalonica issued in the name of three emperors – Gratian, Valentinian II, and Theodosius I – with Theodosius clearly the driving force behind it. He was the last emperor of a unified empire: after his death in 395 his sons, Arcadius and Honorius divided the empire into a western and an eastern part. The seat of government in the Western Roman Empire was transferred to Ravenna after the siege of Milan in 402. During the 5th century, the emperors from the 430s mostly resided in the capital, Rome.\r\n";
	
	public static ArrayList<String> expectedSentences;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		expectedSentences = new ArrayList<>();
		expectedSentences.add("There is archaeological evidence of human occupation of the Rome area from approximately 14,000 years ago, but the dense layer of much younger debris obscures Palaeolithic and Neolithic sites.");
		expectedSentences.add("Several excavations support the view that Rome grew from pastoral settlements on the Palatine Hill built above the area of the future Roman Forum.");
		expectedSentences.add("Despite recent excavations at the Palatine hill, the view that Rome was founded deliberately in the middle of the eighth century BC, as the legend of Romulus suggests, remains a fringe hypothesis.");
		expectedSentences.add("After the legendary foundation by Romulus, Rome was ruled for a period of 244 years by a monarchical system, initially with sovereigns of Latin and Sabine origin, later by Etruscan kings.");
		expectedSentences.add("Rome then began a period characterized by internal struggles between patricians (aristocrats) and plebeians (small landowners), and by constant warfare against the populations of central Italy: Etruscans, Latins, Volsci, Aequi, Marsi.");
		expectedSentences.add("After becoming master of Latium, Rome led several wars (against the Gauls, Osci-Samnites and the Greek colony of Taranto, allied with Pyrrhus, king of Epirus) whose result was the conquest of the Italian peninsula, from the central area up to Magna Graecia.");
		expectedSentences.add("Rome was established as a de facto empire, which reached its greatest expansion in the second century under the Emperor Trajan.");
		expectedSentences.add("Rome was confirmed as caput Mundi, i.");
		expectedSentences.add("After the end of the Severan Dynasty in 235, the Empire entered into 50-year period known as the Crisis of the Third Century during which there were numerous putsches by generals, who sought to secure the region of the empire they were entrusted with due to the weakness of central authority in Rome.");
		expectedSentences.add("During the 5th century, the emperors from the 430s mostly resided in the capital, Rome.");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		expectedSentences = null;
	}

	@Test
	void test() {
		
		List<String> sentences = SentenceSearch.searchForSentences("Rome", file);
		
		for (int i = 0; i < expectedSentences.size(); i++) {
			
			assertEquals(expectedSentences.get(i), sentences.get(i));
		}

	}

}