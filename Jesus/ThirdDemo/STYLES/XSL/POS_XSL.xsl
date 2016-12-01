<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
	<xsl:output method="html" encoding="utf-8" version="" indent="yes" standalone="no" media-type="text/html" omit-xml-declaration="no" doctype-system="about:legacy-compat" />

	<html>
		<body>
			<h2 align="center">THE UNIVERSITY OF TEXAS - RIO GRANDE VALLEY</h2>
			<h3 align="center">Degree Type - Bachelor of Science in Computer Science (BSCS)</h3>
			<h3 align="center">Degree Title - Computer Science</h3>

			<div>
				<p>Computer science is the study of the structure, function and application of computers and is central to the rapidly expanding use fo information technology. Computers have traditionally been used in business, engineering and scientifici applications, and now applications are found in almost all human activities from art to zoology. Computer science is both an applied and theoretical discipline, supported by the principles of science, engineering, and mathematics that has a direct and profound impact on the quality of life and society at large.</p>
				<p></p>
				<p>The Department of Computer Science offers three degrees: Bachelor of Science in Computer Science (BSCS), Master of Science in computer science (MSCS), and Master of Science in Information Technology (MSIT). The BSCS degree is accredited by the Accreditation Board for Engineering and Technology Computing Accreditation Commission (CAC/ABET), 111 Market Place, Suite 1050, Baltimore, MD 21202-4012, telephone: (410) 347-7700. The Department offers a Bachelor of Science in Computer Engineering (BSCE) in cooperation with the Department of Electrical Engineering. The Department also offers service courses to fulfill University core curriculum requirements, and computer science courses required for degree programs in engineering, science, and mathematics. Faculty conduct research in computer science, computer science education, and interdisciplinary fields, and contribute their professional service to student advising, mentoring, professional organizations, University activities, industrial interactions, and to the community through professional expertise.</p>
				<p></p>
				<p>The undergraduate curricula in computer science are based on the Association for Computing Machinery and the Institute of Electrical and Electronics Engineers Computer Society recommendations for curricula and reflect the goals of a liberal arts education. The graduate curricula provide advanced and specialized study in the areas of computer science and information technology. The curricula in computer sccience provide the student with marketable expertise to enter the computer and information technology fields, the skills and education required to adopt to the rapidly changing characteristic of the fields, and the foundation to pursue graduate study in computer science and information technology.</p>
			</div>

			<p></p>

			<div>
			<p><b>STUDENT LEARNING OUTCOMES:</b></p>
				<ol>
					<b>
						<li>An ability to apply knowledge of computer and mathematics appropriate to the program's student outcomes and to the discipline.</li>
						<li>An ability to analyze a problem, and identify and define the computing requirements appropriate to its solution.</li>
						<li>An ability to design, implements and evaluate a computer-based system, process, component, or program to meet desired needs.</li>
						<li>An ability to function effectively on teams to accomplish a common goal.</li>
						<li>An understanding of professional, ethical, legal, security and social issues and responsibilities.</li>
						<li>An ability to communicate effectively with a range of audiences.</li>
						<li>An ability to analyze the local and global impact of computing on individuals, organizations, and society.</li>
						<li>Recognition of the need for and an ability to engage in continuing professional development.</li>
						<li>An ability to use current techniques, skills, and tools necessary for computing practice.</li>
						<li>An ability to apply mathematical foundations, algorithmic principles, and computer science theory in the modelling and design of computer-based systems in a way that demonstrates comprehension of the tradeoffs involved in design choices.</li>
						<li>An ability to apply design and development principles in the construction of software systems of varying complexity.</li>
					</b>
				</ol>
			</div>

			<p></p>

			<div>
				<ol type="A">
					<li>
						<b>GENERAL EDUCATION CORE - 42 HOURS</b>

						<p><i>Students must fulfill the General Education Core requirements. The courses listed below satisfy both degree requirements and General Education core requirements.</i></p>

						<ul style="list-style-type:none">
							<li><b>REQUIRED:</b></li>

							<p></p>

							<li>
								<ul style="list-style-type:none">
									<li><b>Mathematics - 3 hours</b></li>

									<li>
										<ul style="list-style-type:none">
												<a href="file:///../XML/COURSES/math-2413/math-2413.xml"><li>MATH 2413 Calculus I (or MATH 2487 Honors) three-hour lecture</li></a>
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
											<li><i>Choose one pair:</i></li>

											<li>
												<ul style="list-style-type:none">
														<a href="file:///../XML/COURSES/biol-1406/biol-1406.xml"><li>BIOL 1406 General Biology I (or BIOL 1487 Honors) three-hour lecture</li></a>
														<a href="file:///../XML/COURSES/biol-1407/biol-1407.xml"><li>BIOL 1407 General Biology II (or BIOL 1488 Honors) three-hour lecture</li></a>
												</ul>
											</li>
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
												<a href="file:///../XML/COURSES/phil-2326/phil-2326.xml"><li>PHIL 2326 Professional Ethics: Engineering</li></a>
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
														<a href="file:///../XML/COURSES/cmpe-1370/cmpe-1307.xml"><li>CSCI/CMPE 1370 Engineering Computer Science I (or CSCI/CMPE 1378 Honors)</li></a>
												</ul>
											</li>
										</ul>
									</li>
								</ul>
							</li>
						</ul>
					</li>

					<p></p>

					<li>
						<b>MAJOR REQUIREMENTS - 44 HOURS (33 advanced)</b>

						<p></p>

						<ol>
							<li>
								<b>Computer Science Core - 29 hours (18 advanced)</b>

								<xsl:for-each select="POS/Course">
									<ul style="list-style-type:none">
										<li>
											<xsl:if test="Divide[text()='Computer_Science_Core']">
												<xsl:variable name="link"><xsl:value-of select="Prefix"/><xsl:text>-</xsl:text><xsl:value-of select="Number"/></xsl:variable>
												<a href="file:///../XML/COURSES/{$link}/{$link}.xml">
													<xsl:value-of select="Prefix"/><xsl:text> </xsl:text><xsl:value-of select="Number"/><xsl:text> </xsl:text><xsl:value-of select="Name"/>
												</a>
											</xsl:if>
										</li>
									</ul>
								</xsl:for-each>
							</li>

							<p></p>

							<li>
								<b>Computer Science Electives - 15 hours (15 advanced)</b>

								<ol type="a">
									<li>
										<b>Programming Language - 3 hours (3 advanced)</b>

										<p><i>Choose from:</i></p>

										<xsl:for-each select="POS/Course">
											<ul style="list-style-type:none">
												<li>
													<xsl:if test="Divide[text()='Computer_Science_Core']">
														<xsl:variable name="link"><xsl:value-of select="Prefix"/><xsl:text>-</xsl:text><xsl:value-of select="Number"/></xsl:variable>
														<a href="file:///../XML/COURSES/{$link}/{$link}.xml">
															<xsl:value-of select="Prefix"/><xsl:text> </xsl:text><xsl:value-of select="Number"/><xsl:text> </xsl:text><xsl:value-of select="Name"/>
														</a>
													</xsl:if>
												</li>
											</ul>
										</xsl:for-each>
									</li>

									<p></p>

									<li>
										<b>Databases, Networking, and Operating Systems - 6 hours (6 advanced)</b>

										<p><i>Choose from:</i></p>

										<xsl:for-each select="POS/Course">
											<ul style="list-style-type:none">
												<li>
													<xsl:if test="Divide[text()='Databases']">
														<xsl:variable name="link"><xsl:value-of select="Prefix"/><xsl:text>-</xsl:text><xsl:value-of select="Number"/></xsl:variable>
														<a href="file:///../XML/COURSES/{$link}/{$link}.xml">
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

										<p><i>Choose from:</i></p>

										<xsl:for-each select="POS/Course">
											<ul style="list-style-type:none">
												<li>
													<xsl:if test="Divide[text()='Technical_Electives']">
														<xsl:variable name="link"><xsl:value-of select="Prefix"/><xsl:text>-</xsl:text><xsl:value-of select="Number"/></xsl:variable>
														<a href="file:///../XML/COURSES/{$link}/{$link}.xml">
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

					<li>
						<b>SUPPORT COURSES - 41 HOURS (15 advanced)</b>

						<p></p>

						<ol>
							<li>
								<b>Oral and Written Communication - 6 hours (3 advanced)</b>

								<xsl:for-each select="POS/Course">
									<ul style="list-style-type:none">
										<li>
											<xsl:if test="Divide[text()='Oral']">
												<xsl:variable name="link"><xsl:value-of select="Prefix"/><xsl:text>-</xsl:text><xsl:value-of select="Number"/></xsl:variable>
												<a href="file:///../XML/COURSES/{$link}/{$link}.xml">
													<xsl:value-of select="Prefix"/><xsl:text> </xsl:text><xsl:value-of select="Number"/><xsl:text> </xsl:text><xsl:value-of select="Name"/>
												</a>
											</xsl:if>
										</li>
									</ul>
								</xsl:for-each>
							</li>

							<p></p>

							<li>
								<b>Mathematics and Engineering - 18 hours (6 advanced)</b>

								<xsl:for-each select="POS/Course">
									<ul style="list-style-type:none">
										<li>
											<xsl:if test="Divide[text()='Oral']">
												<xsl:variable name="link"><xsl:value-of select="Prefix"/><xsl:text>-</xsl:text><xsl:value-of select="Number"/></xsl:variable>
												<a href="file:///../XML/COURSES/{$link}/{$link}.xml">
													<xsl:value-of select="Prefix"/><xsl:text> </xsl:text><xsl:value-of select="Number"/><xsl:text> </xsl:text><xsl:value-of select="Name"/>
												</a>
											</xsl:if>
										</li>
									</ul>
								</xsl:for-each>

							</li>

						<p></p>

						<li>
							<b>Laboratory - 2 hours</b>

							<xsl:for-each select="POS/Course">
								<ul style="list-style-type:none">
									<li>
										<xsl:if test="Divide[text()='Lab']">
											<xsl:variable name="link"><xsl:value-of select="Prefix"/><xsl:text>-</xsl:text><xsl:value-of select="Number"/></xsl:variable>
											<a href="file:///../XML/COURSES/{$link}/{$link}.xml">
												<xsl:value-of select="Prefix"/><xsl:text> </xsl:text><xsl:value-of select="Number"/><xsl:text> </xsl:text><xsl:value-of select="Name"/>
											</a>
										</xsl:if>
									</li>
								</ul>
							</xsl:for-each>

						</li>

					<p></p>

					<li>
						<b>Basic Science - 4 hours</b>

						<xsl:for-each select="POS/Course">
							<ul style="list-style-type:none">
								<li>
									<xsl:if test="Divide[text()='Basic']">
										<xsl:variable name="link"><xsl:value-of select="Prefix"/><xsl:text>-</xsl:text><xsl:value-of select="Number"/></xsl:variable>
										<a href="file:///../XML/COURSES/{$link}/{$link}.xml">
											<xsl:value-of select="Prefix"/><xsl:text> </xsl:text><xsl:value-of select="Number"/><xsl:text> </xsl:text><xsl:value-of select="Name"/>
										</a>
									</xsl:if>
								</li>
							</ul>
						</xsl:for-each>

					</li>

				<p></p>

				<li>
					<b>Free Electives - 4 hours</b>

					<xsl:for-each select="POS/Course">
						<ul style="list-style-type:none">
							<li>
								<xsl:if test="Divide[text()='Free']">
									<xsl:variable name="link"><xsl:value-of select="Prefix"/><xsl:text>-</xsl:text><xsl:value-of select="Number"/></xsl:variable>
									<a href="file:///../XML/COURSES/{$link}/{$link}.xml">
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
					<li>All courses in the Computer Science Core must be completed with a grade 'C' or better.</li>
				</ul>
			</ul>
		</body>
	</html>
</xsl:template>
</xsl:stylesheet>
