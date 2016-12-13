<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
	<xsl:output method="html" encoding="utf-8" version="" indent="yes" standalone="no" media-type="text/html" omit-xml-declaration="no" doctype-system="about:legacy-compat" />

<!-- Introduction -->
	<html>
		<body>
			<h2 align="center">THE UNIVERSITY OF TEXAS - RIO GRANDE VALLEY</h2>
			<h3 align="center">Degree Type - Bachelor of Science in Computer Engineering (BSCE) </h3>
			<h3 align="center">Degree Title - Degree Title – Computer Engineering</h3>

			<div>
				<p>Computer engineering is a broad field with applications in almost all areas of industry including software and hardware computer systems, and computing electronics. The Department of Computer Science and the Department of Electrical Engineering jointly offers the Bachelor of Science in Computer Engineering (BSCE) degree, accredited by ABET since 2009.</p>
				<p></p>
				<p>The program awards a Bachelor of Science in Computer Engineering (BSCE). Computer engineering is a discipline that embodies the science and technology of design, construction and implementation of software and hardware components of modern computing hardware and software systems and computer-controlled equipment. The body of knowledge for computer engineering includes algorithms, computer architecture and organization, computer systems engineering, circuits and signals, database systems, digital logic, digital signal processing, electronics, embedded systems, computer networks, operating systems, programming, software engineering and discrete structures. The curriculum was designed following the guidelines of ACM and IEEE model curricula to meet ABET standards.</p>
				<p></p>
				<p>This degree provides a broad, solid education in computer engineering fundamentals as well as the opportunity for in- depth study in specialized topics. Students completing the program will have a rigorous foundation for software and hardware engineering practice in industry as well as for graduate studies in computer science, computer engineering and other related disciplines. The program has well-equipped, accessible laboratories and extensive computing facilities.</p>
				<p></p>
				<p>The Computer Engineering Program is a joint program delivered by the Department of Computer Science and the Department of Electrical Engineering. The Computer Engineering program prepares students to pursue advanced study or to enter the dynamic and interdisciplinary field that continues to experience rapid growth and impacts many aspects of human endeavor. The program is designed to provide students with a balanced perspective of hardware and software, and the analysis, design, and implementation techniques for integrated computer systems. The faculty endeavor to be accessible, maintain state of the art instruction and facilities, and to provide liberal access to laboratories and academic support.</p>
			</div>

			<p></p>

			<div>
			<p><b>STUDENT LEARNING OUTCOMES:</b></p>
				<ol>
					<b>
						<li>A knowledge of mathematics and basic sciences necessary for the analysis and design of computer software, hardware, and systems.</li>
						<li>An understanding of the principles of computer programming, software engineering, algorithms, data structures, computer organization and architecture, operating systems, and computer networking.</li>
						<li>An understanding of the principles of microprocessor systems, digital electronics, electrical circuits, electronics, and embedded systems, and an understanding of the applications of computer engineering principles.</li>
						<li>An ability to use analysis and design tools to produce integrated systems containing hardware and software.</li>
						<li>A depth and breadth of knowledge that goes beyond the basic skills expected of all computer engineering students with further specialization in either the software track or the hardware track.</li>
						<li>An ability to apply these principles and practices to a variety of computer engineering problems.</li>
						<li>An ability to successfully complete design projects of substantial complexity.</li>
						<li>An ability to understand and learn new technological developments in the field.</li>
						<li>An ability to work effectively in teams.</li>
						<li>An ability to communicate effectively in graphical, oral, and written media.</li>
						<li>An understanding of the professional responsibility of an engineer and how engineering solutions impact safety, economics, ethics, politics, and societal and cultural issues.</li>
					</b>
				</ol>
			</div>

			<p></p>

<!-- General Education -->
			<div>
				<ol type="A">
					<li>
						<b>GENERAL EDUCATION CORE (MATH) - 42 HOURS</b>
						<p><i>Students must fulfill the General Education Core requirements. The courses listed below satisfy both degree requirements and General Education core requirements.</i></p>


						<ul style="list-style-type:none">
							<li><b>REQUIRED: </b></li>

							<p></p>

							<li>
								<ul style="list-style-type:none">
									<li><b>Mathematics - 3 hours</b></li>

									<li>
										<ul style="list-style-type:none">
											<a href="../HTML/math-2413.html"><li>MATH 2413 Calculus I (or MATH 2487 Honors) three-hour lecture</li></a>
										</ul>
									</li>
								</ul>
							</li>

							<p></p>

							<li>
								<ul style="list-style-type:none">
									<li><b>Life and Physical Science - 6 hours</b></li>

									<li>
										<ul style="list-style-type:none">
											<a href="../HTML/phys-2425.html"><li>PHYS 2425 Physics for Scientist and Engineers I three-hour lecture</li></a>
											<a href="../HTML/phys-2426l.html"><li>PHYS 2426 Physics for Scientist and Engineers II three-hour lecture </li></a>
										</ul>
									</li>
								</ul>
							</li>

							<p></p>

							<li>
								<ul style="list-style-type:none">
									<li><b>Language, Philosophy, and Culture - 3 hours</b></li>

									<li>
										<ul style="list-style-type:none">
											<a href="../HTML/phil-2326.html"><li>PHIL 2326 Professional Ethics: Engineering</li></a>
										</ul>
									</li>
								</ul>
							</li>

							<p></p>

							<li>
								<ul style="list-style-type:none">
									<li><b>Integrative and Experiential Learning - 6 hours</b></li>

									<li>
										<ul style="list-style-type:none">
											<li><i>Choose any course from Humanities, except for Professional Ethics, and complete:</i></li>

											<li>
												<ul style="list-style-type:none">
													<a href="../HTML/cmpe-1370.html"><li>CSCI/CMPE 1370 Engineering Computer Science I (or CSCI/CMPE 1378 Honors)</li></a>
												</ul>
											</li>
										</ul>
									</li>
								</ul>
							</li>
						</ul>
					</li>

					<p></p>

<!-- Major Requirements -->
					<li>
						<b>MAJOR REQUIREMENTS - 65 HOURS (49 advanced minimum)</b>

						<p></p>

						<ol>
							<li>
								<b>Computer Engineering Core - 38 hours (25 advanced)</b>

								<xsl:for-each select="POS/Course">
									<ul style="list-style-type:none">
										<li>
											<xsl:if test="Divide[text()='Computer Engineering Core']">
												<xsl:variable name="link"><xsl:value-of select="Prefix"/><xsl:text>-</xsl:text><xsl:value-of select="Number"/></xsl:variable>
												<a href="../HTML/{$link}.html">
													<xsl:value-of select="Prefix"/><xsl:text> </xsl:text><xsl:value-of select="Number"/><xsl:text> </xsl:text><xsl:value-of select="Name"/>
												</a>
											</xsl:if>
										</li>
									</ul>
								</xsl:for-each>
							</li>

							<p></p>

							<li>
								<b>Senior Design - 6 hours (6 advanced)</b>

								<p><i>Choose from:</i></p>

								<xsl:for-each select="POS/Course">
									<ul style="list-style-type:none">
										<li>
											<xsl:if test="Divide[text()='Computer Engineering Senior Design']">
												<xsl:variable name="link"><xsl:value-of select="Prefix"/><xsl:text>-</xsl:text><xsl:value-of select="Number"/></xsl:variable>
												<a href="../HTML/{$link}.html">
													<xsl:value-of select="Prefix"/><xsl:text> </xsl:text><xsl:value-of select="Number"/><xsl:text> </xsl:text><xsl:value-of select="Name"/>
												</a>
											</xsl:if>
										</li>
									</ul>
								</xsl:for-each>
							</li>

							<p></p>

							<li>
								<b>Technical Electives - 6 hours (6 advanced)</b>

								<p><i>Choose from (Additional courses avalibale with Advisor or Program Director Approval):</i></p>

								<xsl:for-each select="POS/Course">
									<ul style="list-style-type:none">
										<li>
											<xsl:if test="Divide[text()='Computer Engineering Technical Elective']">
												<xsl:variable name="link"><xsl:value-of select="Prefix"/><xsl:text>-</xsl:text><xsl:value-of select="Number"/></xsl:variable>
												<a href="../HTML/{$link}.html">
													<xsl:value-of select="Prefix"/><xsl:text> </xsl:text><xsl:value-of select="Number"/><xsl:text> </xsl:text><xsl:value-of select="Name"/>
												</a>
											</xsl:if>
										</li>
									</ul>
								</xsl:for-each>
							</li>

							<p></p>

							<li>
								<b>Concentrations - 15 hours (12 advanced minimum)</b>

								<p><i>Choose one concentration:</i></p>

								<ol type="a">
									<li>
										<b>Software - 15 hours (12 advanced minimum)</b>

										<xsl:for-each select="POS/Course">
											<ul style="list-style-type:none">
												<li>
													<xsl:if test="Divide[text()='Computer Engineering Software Concentration']">
														<xsl:variable name="link"><xsl:value-of select="Prefix"/><xsl:text>-</xsl:text><xsl:value-of select="Number"/></xsl:variable>
														<a href="../HTML/{$link}.html">
															<xsl:value-of select="Prefix"/><xsl:text> </xsl:text><xsl:value-of select="Number"/><xsl:text> </xsl:text><xsl:value-of select="Name"/>
														</a>
													</xsl:if>
												</li>
											</ul>
										</xsl:for-each>
									</li>

									<li>
										<b>Hardware - 15 hours (12 advanced minimum)</b>

										<xsl:for-each select="POS/Course">
											<ul style="list-style-type:none">
												<li>
													<xsl:if test="Divide[text()='Computer Engineering Hardware Concentration']">
														<xsl:variable name="link"><xsl:value-of select="Prefix"/><xsl:text>-</xsl:text><xsl:value-of select="Number"/></xsl:variable>
														<a href="../HTML/{$link}.html">
															<xsl:value-of select="Prefix"/><xsl:text> </xsl:text><xsl:value-of select="Number"/><xsl:text> </xsl:text><xsl:value-of select="Name"/>
														</a>
													</xsl:if>
												</li>
											</ul>
										</xsl:for-each>
									</li>
								</ol>
							</li>
						</ol>
					</li>

					<p></p>

<!-- Support Courses -->
					<li>
						<b>Support Courses - 19 HOURS (6 advanced)</b>

						<p></p>

						<ol>
							<li>
								<b>Physics Lab - 2 hours</b>


									<ul style="list-style-type:none">
										<a href="../HTML/phys-2425.html"><li>PHYS 2425 Physics for Scientist and Engineers I one-hour lab</li></a>
										<a href="../HTML/phys-2426.html"><li>PHYS 2426 Physics for Scientist and Engineers II one-hour lab </li></a>
									</ul>

							</li>

							<p></p>

							<li>
								<b>Basic Science - 3 hours</b>

								<p><i>Choose one concentration:</i></p>


									<ul style="list-style-type:none">
										<a href="../HTML/chem-1311.html"><li>General Chemistry I</li></a>
										<a href="../HTML/chem-1307.html"><li>Chemistry for Engineers</li></a>
									</ul>

							</li>

							<p></p>

							<li>
								<b>Mathematics - 14 hours</b>


									<ul style="list-style-type:none">
										<a href="../HTML/math-2413.html"><li>Calculus I (or MATH 2487 Honors) one-hour lecture</li></a>
										<a href="../HTML/math-2414.html"><li>Calculus II (or MATH 2488 Honors)</li></a>
										<a href="../HTML/math-2346.html"><li>Mathematics for Electrical and Computer Engineers</li></a>
										<a href="../HTML/math-2341.html"><li>Differential Equations</li></a>
										<a href="../HTML/math-2337.html"><li>Probability and Statistics</li></a>
									</ul>

							</li>
						</ol>
					</li>
				</ol>
			</div>

			<p></p>

			<p><b>TOTAL CREDIT HOURS FOR GRADUATION - 127 HOURS</b></p>
			<p></p>
			<p><b>TOTAL ADVANCED HOURS - 48 HOURS</b></p>
			<p></p>
			<p><b>ADMISSION, PROGRESSION, AND GRADUATION REQUIREMENTS, if applicable:</b></p>

			<ul style="list-style-type:none">
				<li><b>Graduation requirements:</b></li>

				<ul style="list-style-type:none">
					<li>As part of the degree, all students must complete a two-semester capstone senior design project, represented by CMPE 4371 and CMPE 4372 or CMPE 4372 and CMPE 4374 in the degree plan. This project must be of substantial scope and complexity, demonstrate competencies from across the curriculum (in particular, the ability to design computer software, electronic hardware and integrate the two in systems) and address the social, economic and ethical consequences of the project.</li>
				</ul>
			</ul>
		</body>
	</html>
</xsl:template>
</xsl:stylesheet>
