-- phpMyAdmin SQL Dump
-- version 3.2.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 09. Juli 2011 um 23:03
-- Server Version: 5.1.44
-- PHP-Version: 5.3.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `jProject`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Comment`
--

CREATE TABLE `Comment` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `User` varchar(255) NOT NULL,
  `Entry` text NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `FKComment124517` (`User`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Daten für Tabelle `Comment`
--

INSERT INTO `Comment` VALUES(2, 'userloginname', 'Comment');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `CommentDocument`
--

CREATE TABLE `CommentDocument` (
  `CommentID` int(10) NOT NULL,
  `DocumentID` int(10) NOT NULL,
  PRIMARY KEY (`CommentID`),
  KEY `FKCommentDoc222377` (`CommentID`),
  KEY `FKCommentDoc892377` (`DocumentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `CommentDocument`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `CommentProject`
--

CREATE TABLE `CommentProject` (
  `CommentID` int(10) NOT NULL,
  `Project` varchar(255) NOT NULL,
  PRIMARY KEY (`CommentID`),
  KEY `FKCommentPro655506` (`CommentID`),
  KEY `FKCommentPro755040` (`Project`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `CommentProject`
--

INSERT INTO `CommentProject` VALUES(2, 'ProjectName');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `CommentSourcecode`
--

CREATE TABLE `CommentSourcecode` (
  `CommentID` int(10) NOT NULL,
  `SourcecodeID` int(10) NOT NULL,
  PRIMARY KEY (`CommentID`),
  KEY `FKCommentSou638505` (`CommentID`),
  KEY `FKCommentSou273811` (`SourcecodeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `CommentSourcecode`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `CommentTask`
--

CREATE TABLE `CommentTask` (
  `CommentID` int(10) NOT NULL,
  `TaskID` int(10) NOT NULL,
  PRIMARY KEY (`CommentID`),
  KEY `FKCommentTas532422` (`CommentID`),
  KEY `FKCommentTas995932` (`TaskID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `CommentTask`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Document`
--

CREATE TABLE `Document` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Project` varchar(255) NOT NULL,
  `Dateiname` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `FKDocument497399` (`Project`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Daten für Tabelle `Document`
--

INSERT INTO `Document` VALUES(1, 'ProjectName', 'Dateiname');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `GlobalRoles`
--

CREATE TABLE `GlobalRoles` (
  `Role` varchar(255) NOT NULL,
  `AddNewProjectAction` tinyint(1) NOT NULL DEFAULT '0',
  `DeleteProjectAction` tinyint(1) NOT NULL,
  `ShowProjectAction` tinyint(1) NOT NULL,
  `SearchProjectsAction` tinyint(1) NOT NULL,
  `ShowAllProjectsAction` tinyint(1) NOT NULL,
  `ShowAllOwnProjectAction` tinyint(1) NOT NULL,
  `DeleteUserAction` tinyint(1) NOT NULL,
  `ShowUserSettingsAction` tinyint(1) NOT NULL,
  `UpdateUserSettingsAction` tinyint(1) NOT NULL,
  `ShowUserInfoAction` tinyint(1) NOT NULL,
  `SearchUserAction` tinyint(1) NOT NULL,
  `ShowAllUserAction` tinyint(1) NOT NULL,
  `RegisterAction` tinyint(1) NOT NULL,
  `CommentDocuAction` tinyint(1) NOT NULL DEFAULT '0',
  `CommentSourceAction` tinyint(1) NOT NULL DEFAULT '0',
  `CommentTaskAction` tinyint(1) NOT NULL DEFAULT '0',
  `CommentProjectAction` tinyint(1) NOT NULL,
  `DeleteCommentAction` tinyint(1) NOT NULL DEFAULT '0',
  `ShowAllComments41DocuAction` tinyint(1) NOT NULL,
  `ShowAllComments41SourceAction` tinyint(1) NOT NULL,
  `ShowAllComments41TaskAction` tinyint(1) NOT NULL,
  `ShowAllComments41ProjectAction` tinyint(1) NOT NULL,
  `UpdateCommentAction` tinyint(1) NOT NULL,
  `AddNewDocuAction` tinyint(1) NOT NULL DEFAULT '0',
  `DeleteDocuAction` tinyint(1) NOT NULL DEFAULT '0',
  `DownloadDocuAction` tinyint(1) NOT NULL DEFAULT '0',
  `ShowDocuAction` tinyint(1) NOT NULL,
  `ShowAllDocuAction` tinyint(1) NOT NULL DEFAULT '0',
  `UpdateDocuAction` tinyint(1) NOT NULL,
  `AddMemberAction` tinyint(1) NOT NULL DEFAULT '0',
  `DeleteMemberAction` tinyint(1) NOT NULL,
  `ShowAllMemberAction` tinyint(1) NOT NULL,
  `AddNewSourceAction` tinyint(1) NOT NULL,
  `DeleteSourceAction` tinyint(1) NOT NULL,
  `DownloadSourceAction` tinyint(1) NOT NULL,
  `ShowSourceAction` tinyint(1) NOT NULL,
  `ShowAllSourceAction` tinyint(1) NOT NULL,
  `UpdateSourceAction` tinyint(1) NOT NULL,
  `AddNewTaskAction` tinyint(1) NOT NULL,
  `DeleteTaskAction` tinyint(1) NOT NULL,
  `ShowAllTasksAction` tinyint(1) NOT NULL,
  `ShowAllOwnTasksAction` tinyint(1) NOT NULL,
  `UpdateTaskAction` tinyint(1) NOT NULL,
  `OpenAdminconsoleAction` tinyint(1) NOT NULL,
  `ChangeGlobalRoleAction` tinyint(1) NOT NULL,
  `ShowTaskAction` tinyint(1) NOT NULL,
  `ShowMemberAction` tinyint(1) NOT NULL,
  PRIMARY KEY (`Role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `GlobalRoles`
--

INSERT INTO `GlobalRoles` VALUES('Admin', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `GlobalRoles` VALUES('Member', 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `ICQ`
--

CREATE TABLE `ICQ` (
  `ICQNumber` varchar(255) NOT NULL,
  `UserLoginName` varchar(255) NOT NULL,
  PRIMARY KEY (`ICQNumber`),
  KEY `FKICQ715377` (`UserLoginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `ICQ`
--

INSERT INTO `ICQ` VALUES('123456789', 'userloginname');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Member`
--

CREATE TABLE `Member` (
  `User` varchar(255) NOT NULL,
  `Project` varchar(255) NOT NULL,
  `ProjectRole` varchar(255) NOT NULL,
  PRIMARY KEY (`User`,`Project`),
  KEY `FKMember111780` (`User`),
  KEY `FKMember203878` (`Project`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `Member`
--

INSERT INTO `Member` VALUES('admin', 'ProjectName', 'Member');
INSERT INTO `Member` VALUES('userloginname', 'ProjectName', 'Leader');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Project`
--

CREATE TABLE `Project` (
  `Name` varchar(255) NOT NULL,
  `Status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `Project`
--

INSERT INTO `Project` VALUES('ProjectName', 'Status');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `ProjectRoles`
--

CREATE TABLE `ProjectRoles` (
  `Role` varchar(255) NOT NULL,
  `CommentDocuAction` tinyint(1) NOT NULL DEFAULT '0',
  `CommentSourceAction` tinyint(1) NOT NULL DEFAULT '0',
  `CommentTaskAction` tinyint(1) NOT NULL DEFAULT '0',
  `CommentProjectAction` tinyint(1) NOT NULL,
  `DeleteCommentAction` tinyint(1) NOT NULL DEFAULT '0',
  `ShowAllComments41DocuAction` tinyint(1) NOT NULL,
  `ShowAllComments41SourceAction` tinyint(1) NOT NULL,
  `ShowAllComments41TaskAction` tinyint(1) NOT NULL,
  `ShowAllComments41ProjectAction` tinyint(1) NOT NULL,
  `UpdateCommentAction` tinyint(1) NOT NULL,
  `AddNewDocuAction` tinyint(1) NOT NULL DEFAULT '0',
  `DeleteDocuAction` tinyint(1) NOT NULL DEFAULT '0',
  `DownloadDocuAction` tinyint(1) NOT NULL DEFAULT '0',
  `ShowDocuAction` tinyint(1) NOT NULL,
  `ShowAllDocuAction` tinyint(1) NOT NULL DEFAULT '0',
  `UpdateDocuAction` tinyint(1) NOT NULL,
  `AddMemberAction` tinyint(1) NOT NULL DEFAULT '0',
  `DeleteMemberAction` tinyint(1) NOT NULL,
  `ShowAllMemberAction` tinyint(1) NOT NULL,
  `AddNewSourceAction` tinyint(1) NOT NULL,
  `DeleteSourceAction` tinyint(1) NOT NULL,
  `DownloadSourceAction` tinyint(1) NOT NULL,
  `ShowSourceAction` tinyint(1) NOT NULL,
  `ShowAllSourceAction` tinyint(1) NOT NULL,
  `UpdateSourceAction` tinyint(1) NOT NULL,
  `AddNewTaskAction` tinyint(1) NOT NULL,
  `DeleteTaskAction` tinyint(1) NOT NULL,
  `ShowAllTasksAction` tinyint(1) NOT NULL,
  `ShowAllOwnTasksAction` tinyint(1) NOT NULL,
  `UpdateTaskAction` tinyint(1) NOT NULL,
  `DeleteProjectAction` tinyint(1) NOT NULL,
  `DeAssignTaskAction` tinyint(1) NOT NULL,
  `AssignTaskAction` tinyint(1) NOT NULL,
  `ShowTaskAction` tinyint(1) NOT NULL,
  `ShowMemberAction` tinyint(1) NOT NULL,
  PRIMARY KEY (`Role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `ProjectRoles`
--

INSERT INTO `ProjectRoles` VALUES('Leader', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `ProjectRoles` VALUES('Member', 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Skype`
--

CREATE TABLE `Skype` (
  `SkypeName` varchar(255) NOT NULL,
  `UserLoginName` varchar(255) NOT NULL,
  PRIMARY KEY (`SkypeName`),
  KEY `FKSkype602880` (`UserLoginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `Skype`
--

INSERT INTO `Skype` VALUES('SkypeName', 'userloginname');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Sourcecode`
--

CREATE TABLE `Sourcecode` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Project` varchar(255) NOT NULL,
  `Dateiname` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `FKSourcecode392374` (`Project`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Daten für Tabelle `Sourcecode`
--

INSERT INTO `Sourcecode` VALUES(1, 'ProjectName', 'Dateiname');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Task`
--

CREATE TABLE `Task` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Project` varchar(255) NOT NULL,
  `Titel` varchar(255) NOT NULL,
  `Aufgabenstellung` text NOT NULL,
  `Done` tinyint(1) NOT NULL DEFAULT '0',
  `TerminID` int(10) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `FKTask263977` (`Project`),
  KEY `FKTask626088` (`TerminID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Daten für Tabelle `Task`
--

INSERT INTO `Task` VALUES(1, 'ProjectName', 'Titel', 'Aufgabenstellung', 1, NULL);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Telefon`
--

CREATE TABLE `Telefon` (
  `TelNumber` varchar(255) NOT NULL,
  `UserLoginName` varchar(255) NOT NULL,
  PRIMARY KEY (`TelNumber`),
  KEY `FKTelefon936160` (`UserLoginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `Telefon`
--

INSERT INTO `Telefon` VALUES('12345678', 'userloginname');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `Termin`
--

CREATE TABLE `Termin` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Termin` date NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Daten für Tabelle `Termin`
--


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `TODO`
--

CREATE TABLE `TODO` (
  `MemberUser` varchar(255) NOT NULL,
  `MemberProject` varchar(255) NOT NULL,
  `TaskID` int(10) NOT NULL,
  PRIMARY KEY (`MemberUser`,`MemberProject`,`TaskID`),
  KEY `FKTODO442996` (`MemberUser`,`MemberProject`),
  KEY `FKTODO825529` (`TaskID`),
  KEY `MemberProject` (`MemberProject`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `TODO`
--

INSERT INTO `TODO` VALUES('userloginname', 'ProjectName', 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `User`
--

CREATE TABLE `User` (
  `LoginName` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Vorname` varchar(255) NOT NULL,
  `Nachname` varchar(255) NOT NULL,
  `Sprache` varchar(255) NOT NULL DEFAULT 'Deutsch',
  `GlobalRole` varchar(255) NOT NULL DEFAULT 'Member',
  PRIMARY KEY (`LoginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `User`
--

INSERT INTO `User` VALUES('admin', '8be3c943b1609fffbfc51aad666d0a04adf83c9d', 'voradmin', 'nachadmin', 'Deutsch', 'Admin');
INSERT INTO `User` VALUES('userloginname', '8be3c943b1609fffbfc51aad666d0a04adf83c9d', 'Vorname', 'Nachname', 'Sprache', 'Member');

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `Comment`
--
ALTER TABLE `Comment`
  ADD CONSTRAINT `FKComment124517` FOREIGN KEY (`User`) REFERENCES `user` (`LoginName`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `CommentDocument`
--
ALTER TABLE `CommentDocument`
  ADD CONSTRAINT `FKCommentDoc892377` FOREIGN KEY (`DocumentID`) REFERENCES `document` (`ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKCommentDoc222377` FOREIGN KEY (`CommentID`) REFERENCES `comment` (`ID`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `CommentProject`
--
ALTER TABLE `CommentProject`
  ADD CONSTRAINT `FKCommentPro755040` FOREIGN KEY (`Project`) REFERENCES `project` (`Name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKCommentPro655506` FOREIGN KEY (`CommentID`) REFERENCES `comment` (`ID`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `CommentSourcecode`
--
ALTER TABLE `CommentSourcecode`
  ADD CONSTRAINT `FKCommentSou273811` FOREIGN KEY (`SourcecodeID`) REFERENCES `sourcecode` (`ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKCommentSou638505` FOREIGN KEY (`CommentID`) REFERENCES `comment` (`ID`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `CommentTask`
--
ALTER TABLE `CommentTask`
  ADD CONSTRAINT `FKCommentTas995932` FOREIGN KEY (`TaskID`) REFERENCES `task` (`ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKCommentTas532422` FOREIGN KEY (`CommentID`) REFERENCES `comment` (`ID`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `Document`
--
ALTER TABLE `Document`
  ADD CONSTRAINT `FKDocument497399` FOREIGN KEY (`Project`) REFERENCES `project` (`Name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `ICQ`
--
ALTER TABLE `ICQ`
  ADD CONSTRAINT `FKICQ715377` FOREIGN KEY (`UserLoginName`) REFERENCES `user` (`LoginName`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `Member`
--
ALTER TABLE `Member`
  ADD CONSTRAINT `FKMember203878` FOREIGN KEY (`Project`) REFERENCES `project` (`Name`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKMember111780` FOREIGN KEY (`User`) REFERENCES `user` (`LoginName`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `Skype`
--
ALTER TABLE `Skype`
  ADD CONSTRAINT `FKSkype602880` FOREIGN KEY (`UserLoginName`) REFERENCES `user` (`LoginName`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `Sourcecode`
--
ALTER TABLE `Sourcecode`
  ADD CONSTRAINT `FKSourcecode392374` FOREIGN KEY (`Project`) REFERENCES `project` (`Name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `Task`
--
ALTER TABLE `Task`
  ADD CONSTRAINT `FKTask626088` FOREIGN KEY (`TerminID`) REFERENCES `termin` (`ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKTask263977` FOREIGN KEY (`Project`) REFERENCES `project` (`Name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `Telefon`
--
ALTER TABLE `Telefon`
  ADD CONSTRAINT `FKTelefon936160` FOREIGN KEY (`UserLoginName`) REFERENCES `user` (`LoginName`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints der Tabelle `TODO`
--
ALTER TABLE `TODO`
  ADD CONSTRAINT `todo_ibfk_2` FOREIGN KEY (`MemberProject`) REFERENCES `member` (`Project`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKTODO442996` FOREIGN KEY (`MemberUser`, `MemberProject`) REFERENCES `member` (`User`, `Project`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKTODO825529` FOREIGN KEY (`TaskID`) REFERENCES `task` (`ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `todo_ibfk_1` FOREIGN KEY (`MemberUser`) REFERENCES `member` (`User`) ON DELETE CASCADE ON UPDATE CASCADE;
