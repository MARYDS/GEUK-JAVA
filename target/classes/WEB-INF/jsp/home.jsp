<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html >
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/script.js" />" ></script>
<title>General Election Results UK</title>
</head>

<body>
	<div id="app">

		<div class="mainResultsPage">

			<!------------------------------------------ Page Header ------------------------------------------>
			<div>
				<div class="mainTitleArea">
					<h2 class="mainTitle">${electionYear}&nbsp;UK Election results</h2>
				</div>
				<div class="mainTitleBlock">
					<h2 class="mainTitle">${electionYear}&nbsp;UK Election results</h2>
				</div>
			</div>
			<!------------------------------------------ End Page Header -------------------------------------->


			<!------------------------------------------ Detail List ----------------------------------------->
			<c:if test="${selectedConstituency != ''}">
				<c:set var = "wikiArticle" value = "https://en.wikipedia.org/wiki/${selectedConstituency.replace(' ', '_')}_(UK_Parliament_constituency)"/>
			
				<div class="detailResultsArea" id="detailResultsArea">

					<div class="detailResultsOverall" id="detailResultsOverall">

						<div class="detailResultsTitleArea">
							<h3 class="detailResultsTitle">
								<a href=${wikiArticle} target="_blank">${selConSummary.constituency.constituencyName}</a>
							</h3>
						</div>

						<div class="detailResultsOverallLeft">
							<span class="detailResultsOverallText">${selConSummary.year}</span>
							<canvas class="detailResultsOverallCanvas" id="canvas" width=125
								height=125></canvas>
						</div>

						<div class="detailResultsOverallCenter">
							<table>
								<tbody>
									<tr>
										<td class="detailResultsOverallText">Electorate:</td>
										<td class="detailResultsOverallNumber"><fmt:formatNumber
												type="number" value="${selConSummary.electorate}" /></td>
									</tr>
									<tr>
										<td class="detailResultsOverallText">Valid votes:</td>
										<td class="detailResultsOverallNumber"><fmt:formatNumber
												type="number" value="${selConSummary.validVotes}" /></td>
									</tr>
									<tr>
										<td class="detailResultsOverallText">Invalid votes:</td>
										<td class="detailResultsOverallNumber"><fmt:formatNumber
												type="number" value="${selConSummary.invalidVotes}" /></td>
									</tr>
									<tr>
										<td class="detailResultsOverallText">Turnout %:</td>
										<td class="detailResultsOverallNumber">${selConSummary.turnoutPercent}</td>
									</tr>
									<tr>
										<td class="detailResultsOverallText">Majority Votes:</td>
										<td class="detailResultsOverallNumber"><fmt:formatNumber
												type="number" value="${selConSummary.majority}" /></td>
									</tr>
									<tr>
										<td class="detailResultsOverallText">Majority %:</td>
										<td class="detailResultsOverallNumber">${selConSummary.majorityPercent}</td>
									</tr>
									<tr>
										<td class="detailResultsOverallText">Result</td>
										<td class="detailResultsOverallNumber">${selConSummary.narrative}</td>
									</tr>
								</tbody>
							</table>
						</div>

						<div class="detailResultsOverallRight" id={this.detailId}>
							<span class="detailResultsOverallText">${previousElectionYear}</span>
							<canvas class="detailResultsOverallCanvas" id="canvas2" width=125
								height=125></canvas>
						</div>

					</div>

					<div class="detailResultsDetails">

						<table class="resultsDetailTable">
							<thead>
								<tr>
									<th>&nbsp;</th>
									<th class="resultsDetailCandidate">Candidate</th>
									<th class="resultsDetailPhoto">&nbsp;</th>
									<th class="resultsDetailVotes">Votes</th>
									<th class="resultsDetailShare">Share %</th>
									<th class="resultsDetailChange">Change %</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="detail" items="${detailList}">
									<c:set var="wikiLink" value="javascript:void(0);"/>
								    <c:set var="linkClass" value="resultsDetailCandidateNoLink"/> 
									<c:if test = "${detail.getWiki() != ''}">
										<c:set var="wikiLink" value="https://en.wikipedia.org/wiki/${detail.getWiki()}"/>
										<c:set var="linkClass" value="resultsDetailCandidateLink"/> 
									</c:if>	
									<c:url value="/resources/images/blank.jpg" var="photoImg"/>
									<c:if test = "${detail.getPhoto() == 'Y'}">
										<c:url value="/resources/images/${detail.getFullName()}_${detail.getConstituency().getConstituencyName()}.jpg" var="photoImg"/>
									</c:if>					
									<tr>
										<td class="resultsDetailColour"
											bgColor="${detail.getParty().getColour()}">&nbsp;</td>
										<td class="resultsDetailCandidate"><a href=${wikiLink}
											target="_blank" class=${linkClass}>${detail.getFullName()}</a></td>
										<td class="resultsDetailPhoto" rowSpan="2"><img src="${photoImg}" height="50" width="50"/></td>
										<td class="resultsDetailVotes">
										<fmt:formatNumber type="number" value="${detail.getVotes()}" /></td>
										<td class="resultsDetailShare">${detail.getShare()}</td>
										<td class="resultsDetailChange">${detail.getChange()}</td>
									</tr>
									<tr>
										<td class="resultsDetailColour"
											bgColor="${detail.getParty().getColour()}">&nbsp;</td>
										<td class="resultsDetailParty">${detail.getParty().getName()}</td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
					</div>

					<div class="euResultsDetails">
						<span class="euResultTitle">EU Referendum</span>
						<table class="euResultsDetailTable">
							<thead>
								<tr>
									<th class="euResultsColour">&nbsp;</th>
									<th class="euResultsLocAuth">Local Authority (wards)</th>
									<th class="euResultsElectorate">Electorate</th>
									<th class="euResultsTurnoutPct">Turnout %</th>
									<th class="euResultsRemainVotes">Remain</th>
									<th class="euResultsRemainPct">Remain %</th>
									<th class="euResultsLeaveVotes">Leave</th>
									<th class="euResultsLeavePct">Leave %</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="euRef" items="${euRefList}">
								    <c:if test="${euRef.getRemainVotes() > euRef.getLeaveVotes()}">
								          <c:set var = "resultColour" value = "#FCC822"/>
								    </c:if>
								    <c:if test="${euRef.getRemainVotes() < euRef.getLeaveVotes()}">
								          <c:set var = "resultColour" value = "#0069b5"/>
								    </c:if>
									<tr>
										<td class="euResultsColour" bgColor="${resultColour}">&nbsp;</td>
										<td class="euResultsLocAuth">${euRef.getAreaName()}&nbsp;</td>
										<td class="euResultsElectorate"><fmt:formatNumber type="number" value="${euRef.getElectorate()}" /></td>
										<td class="euResultsTurnoutPct">${euRef.getTurnoutPercent()}</td>
										<td class="euResultsRemainVotes"><fmt:formatNumber type="number" value="${euRef.getRemainVotes()}" /></td>
										<td class="euResultsRemainPct">${euRef.getRemainPercent()}</td>
										<td class="euResultsLeaveVotes"><fmt:formatNumber type="number" value="${euRef.getRemainVotes()}" /></td>
										<td class="euResultsLeavePct">${euRef.getLeavePercent()}</td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
					</div>
				</div>

			</c:if>
			<!------------------------------------------ End Detail List ------------------------------------->
			<!------------------------------------------ Summary List Heading ------------------------------------->

			<div id="summaryResultsHeading">

				<!--  Year selection -->
				<c:if test="${yearsVisible == 'YES'}">
					<div class="resultsSummaryYearArea">
						<form>
							<fieldset class="resultsSummaryYearFieldset">
								<c:forEach var="election" items="${electionYears}">
									<span class="resultsSummaryYearField"> <input
										type="radio" name="year" value=${election[0] } ${election[1]}
										onChange="javascript:window.location.href = 
													'${pageContext.request.contextPath}' + '/SelectYear/' + '${election[0]}'" />
										${election[0]}
									</span>
								</c:forEach>
							</fieldset>
						</form>
					</div>
				</c:if>

				<!--  Region selection -->
				<c:if test="${regionsVisible == 'YES'}">
					<div class="resultsSummaryRegionArea">
						<form>
							<fieldset class="resultsSummaryRegionFieldset">
								<div class="resultsSummaryRegionButtons">
									<button type="button" class="resultsSummaryRegionButton"
										onClick="javascript:window.location.href = 
													'${pageContext.request.contextPath}' + '/SelectRegion/clearall'">
										Clear All</button>
									<button type="button" class="resultsSummaryRegionButton"
										onClick="javascript:window.location.href = 
													'${pageContext.request.contextPath}' + '/SelectRegion/selectall'">
										Select All</button>
								</div>
								<c:forEach var="region" items="${selectedRegions}">
									<span class="resultsSummaryRegionField"> <input
										type="checkbox" name="regions" value=${region[0]
										} ${region[1]}
										onChange="javascript:window.location.href = 
													'${pageContext.request.contextPath}' + '/SelectRegion/' + '${region[0]}'" />
										${region[0]}
									</span>
								</c:forEach>
							</fieldset>
						</form>
					</div>
				</c:if>

				<!--  Party selection -->
				<c:if test="${partiesVisible == 'YES'}">
					<div class="resultsSummaryPartyArea">
						<form>
							<fieldset class="resultsSummaryPartyFieldset">
								<div class="resultsSummaryPartyButtons">
									<button type="button" class="resultsSummaryPartyButton"
										onClick="javascript:window.location.href = 
													'${pageContext.request.contextPath}' + '/SelectParty/clearall'">
										Clear All</button>
									<button type="button" class="resultsSummaryPartyButton"
										onClick="javascript:window.location.href = 
													'${pageContext.request.contextPath}' + '/SelectParty/selectall'">
										Select All</button>
								</div>
								<c:forEach var="party" items="${selectedParties}">
									<span class="resultsSummaryPartyField"> <input
										type="checkbox" name="parties" value=${party[0] } ${party[1]}
										onChange="javascript:window.location.href = 
												'${pageContext.request.contextPath}' + '/SelectParty/' + '${party[0]}'" />
										${party[0]}
									</span>
								</c:forEach>
							</fieldset>
						</form>
					</div>
				</c:if>

				<!--  Sort Order selection -->
				<c:if test="${sortVisible == 'YES'}">
					<div class="resultsSummarySortArea">
						<form>
							<fieldset>
								<span class="resultsSummarySortAreaText">
									<p>Drag sort items into the required sort order, click for
										ascending/descending</p>
								</span>
								<c:forEach var="sortItem" items="${sortOrder}">
									<span>
										<button type="button" id=${sortItem[0]
											}
											class="resultsSummarySortButton">
											${sortItem[0]}&nbsp;
											<c:if test="${sortItem[1] == 'ASC'}">
               									&#x25B2; 
               								</c:if>
											<c:if test="${sortItem[1] == 'DESC'}">
               									&#x25BC;
               								</c:if>
										</button>
									</span>
								</c:forEach>
							</fieldset>
						</form>
					</div>
				</c:if>

				<div class="resultsSummarySearchArea">
					<form>
						<input type="text" class="resultsSummarySearchBox"
							placeholder="Search" value="${searchTerm}" autofocus 
							onfocus="javascript:this.selectionStart = this.selectionEnd = this.value.length;"
								oninput="javascript:window.location.href = 
								'${pageContext.request.contextPath}' + '/Search/' + this.value"/>	
					</form>
				</div>

				<div class="resultsSummaryMenuOptions">
					<button class="resultsSummarySelectButton"
						onClick="javascript:window.location.href = '${pageContext.request.contextPath}' + '/SelectOptions/years'">
						<c:if test="${yearsVisible == 'YES'}">
							Hide Years
						</c:if>
						<c:if test="${yearsVisible == 'NO'}">
							Select Year
						</c:if>
					</button>
					<button class="resultsSummarySelectButton"
						onClick="javascript:window.location.href = '${pageContext.request.contextPath}' + '/SelectOptions/regions'">
						<c:if test="${regionsVisible == 'YES'}">
							Hide Regions
						</c:if>
						<c:if test="${regionsVisible == 'NO'}">
							Select Regions
						</c:if>
					</button>
					<button class="resultsSummarySelectButton"
						onClick="javascript:window.location.href = '${pageContext.request.contextPath}' + '/SelectOptions/parties'">
						<c:if test="${partiesVisible == 'YES'}">
							Hide Parties
						</c:if>
						<c:if test="${partiesVisible == 'NO'}">
							Select Parties
						</c:if>
					</button>
					<button class="resultsSummarySelectButton"
						onClick="javascript:window.location.href = '${pageContext.request.contextPath}' + '/SelectOptions/sort'">
						<c:if test="${sortVisible == 'YES'}">
							Hide Sort Options
						</c:if>
						<c:if test="${sortVisible == 'NO'}">
							Select Sort Options
						</c:if>
					</button>
				</div>

			</div>
			<!------------------------------------------ Summary List ----------------------------------------->

			<div class="resultsSummaryConstituencies">
				<table class="resultsSummaryTable">
					<thead>
						<tr>
							<th colSpan="2" class="summListCon">Constituency / Region</th>
							<th colSpan="2" class="summListMP">Elected MP / Party</th>
							<th colSpan="2" class="summListMar">Margin %</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="summary" items="${summaryList}">
							<tr>
								<td class="summListL1 summListPrev1"
									title="Previous: ${summary.getPrevParty().getPartyCode()}"
									bgColor="${summary.getPrevParty().getColour()}"><a
									href="${pageContext.request.contextPath}/SelectConstituency/${summary.getConstituency().getConstituencyName()}">
										&nbsp; </a></td>
								<td class="summListL1 summListCon"><a
									href="${pageContext.request.contextPath}/SelectConstituency/${summary.getConstituency().getConstituencyName()}">
										${summary.getConstituency().getConstituencyName()} </a></td>
								<td class="summListL1 summListCurr1"
									title="Current: ${summary.getParty().getPartyCode()}"
									bgColor="${summary.getParty().getColour()}"><a
									href="${pageContext.request.contextPath}/SelectConstituency/${summary.getConstituency().getConstituencyName()}">
										&nbsp; </a></td>
								<td class="summListL1 summListMP"><a
									href="${pageContext.request.contextPath}/SelectConstituency/${summary.getConstituency().getConstituencyName()}">
										${summary.getFullName()} </a></td>
								<td class="summListL1 summListMar"><a
									href="${pageContext.request.contextPath}/SelectConstituency/${summary.getConstituency().getConstituencyName()}">
										${summary.getMajorityPercent()} </a></td>
								<td class="summListL1 summListSec1"
									title="Runner Up: ${summary.getRunnerUpParty().getPartyCode()}"
									bgColor="${summary.getRunnerUpParty().getColour()}"><a
									href="${pageContext.request.contextPath}/SelectConstituency/${summary.getConstituency().getConstituencyName()}">
										&nbsp; </a></td>
							</tr>
							<tr>
								<td class="summListL2 summListPrev2"
									title="Previous: ${summary.getPrevParty().getPartyCode()}"
									bgColor="${summary.getPrevParty().getColour()}"><a
									href="${pageContext.request.contextPath}/SelectConstituency/${summary.getConstituency().getConstituencyName()}">
										&nbsp; </a></td>
								<td class="summListL2 summListReg"><a
									href="${pageContext.request.contextPath}/SelectConstituency/${summary.getConstituency().getConstituencyName()}">
										${summary.getConstituency().getRegionName()} </a></td>
								<td class="summListL2 summListCurr2"
									title="Current: ${summary.getParty().getPartyCode()}"
									bgColor="${summary.getParty().getColour()}"><a
									href="${pageContext.request.contextPath}/SelectConstituency/${summary.getConstituency().getConstituencyName()}">
										&nbsp; </a></td>
								<td class="summListL2 summListParty"><a
									href="${pageContext.request.contextPath}/SelectConstituency/${summary.getConstituency().getConstituencyName()}">
										${summary.getParty().getName()} </a></td>
								<td class="summListL2 summListEmpty"><a
									href="${pageContext.request.contextPath}/SelectConstituency/${summary.getConstituency().getConstituencyName()}">
										&nbsp; </a></td>
								<td class="summListL2 summListSec2"
									title="Runner Up: ${summary.getRunnerUpParty().getPartyCode()}"
									bgColor="${summary.getRunnerUpParty().getColour()}"><a
									href="${pageContext.request.contextPath}/SelectConstituency/${summary.getConstituency().getConstituencyName()}">
										&nbsp; </a></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>

		</div>

		<!------------------------------------------ End Summary List ------------------------------------->

		<!-- ---------------------------------------- Page Footer ------------------------------------------>
		<div id="footer">
			<div class="mainFooterArea">
				<span class="mainFooter">2017 Election results mainly
					from&nbsp; <a
					href="http://researchbriefings.parliament.uk/ResearchBriefing/Summary/CBP-7979">House
						of Commons library briefing</a> and news media reports,&nbsp;
				</span> <span class="mainFooter">2015 Election results mainly
					from&nbsp; <a
					href="http://researchbriefings.parliament.uk/ResearchBriefing/Summary/CBP-7186">House
						of Commons library briefing</a>,&nbsp;
				</span> <span class="mainFooter">2010 Election results mainly
					from&nbsp; <a
					href="http://www.electoralcommission.org.uk/our-work/our-research/electoral-data/electoral-data-files-and-reports">Electoral
						Commission, UK Parliament general election</a>, published 6 May
					2010.&nbsp;
				</span> <span class="mainFooter">EU Referendum results mainly
					from&nbsp; <a
					href="https://www.electoralcommission.org.uk/our-work/our-research/electoral-data/electoral-data-files-and-reports">Electoral
						Commission, Referendum on the UK's membership of the EU</a>, published
					23 June 2016.&nbsp;
				</span> <span class="mainFooter">MP photes from&nbsp; <a
					href="https://beta.parliament.uk">UK Parliament Beta site</a>,
					which are under an <a
					href="https://creativecommons.org/licenses/by/3.0/">Attribution
						3.0 Unported (CC BY 3.0)</a> license.
				</span>&nbsp;

			</div>
			<div class="mainFooterBlock">&nbsp;</div>
		</div>
		<!-- ---------------------------------------- End Page Footer -------------------------------------->


	</div>


<script type="text/javascript">
	window.onload = function() { 

		if ('${currentPieDetail}' != '') {		
			updateCanvasLeft('${currentPieDetail}', '${currentPieTotalVotes}')
		}
		if ('${previousPieDetail}' != '') {
			updateCanvasRight('${previousPieDetail}', '${previousPieTotalVotes}')
		}
	} 
</script>

</body>
</html>