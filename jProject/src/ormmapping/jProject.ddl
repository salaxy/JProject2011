CREATE TABLE `User` (
  `LoginName`  varchar(255) NOT NULL, 
  `Password`   varchar(255) NOT NULL, 
  `Vorname`    varchar(255) NOT NULL, 
  `Nachname`   varchar(255) NOT NULL, 
  `Sprache`    varchar(255) DEFAULT 'deutsch' NOT NULL, 
  `GlobalRole` varchar(255) DEFAULT 'Member' NOT NULL, 
  PRIMARY KEY (`LoginName`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Project` (
  `Name`   varchar(255) NOT NULL, 
  `Status` varchar(255), 
  PRIMARY KEY (`Name`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Sourcecode` (
  `ID`        int(10) NOT NULL AUTO_INCREMENT, 
  `Project`   varchar(255) NOT NULL, 
  `Dateiname` varchar(255) NOT NULL, 
  PRIMARY KEY (`ID`), 
  UNIQUE INDEX (`ID`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Document` (
  `ID`        int(10) NOT NULL AUTO_INCREMENT, 
  `Project`   varchar(255) NOT NULL, 
  `Dateiname` varchar(255) NOT NULL, 
  PRIMARY KEY (`ID`), 
  UNIQUE INDEX (`ID`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `ICQ` (
  `ICQNumber`     int(10) NOT NULL AUTO_INCREMENT, 
  `UserLoginName` varchar(255) NOT NULL, 
  PRIMARY KEY (`ICQNumber`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Skype` (
  `SkypeName`     varchar(255) NOT NULL, 
  `UserLoginName` varchar(255) NOT NULL, 
  PRIMARY KEY (`SkypeName`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Telefon` (
  `TelNumber`     int(10) NOT NULL AUTO_INCREMENT, 
  `UserLoginName` varchar(255) NOT NULL, 
  PRIMARY KEY (`TelNumber`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Comment` (
  `ID`    int(10) NOT NULL AUTO_INCREMENT, 
  `User`  varchar(255) NOT NULL, 
  `Entry` text NOT NULL, 
  PRIMARY KEY (`ID`), 
  UNIQUE INDEX (`ID`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Task` (
  `ID`               int(10) NOT NULL AUTO_INCREMENT, 
  `Project`          varchar(255) NOT NULL, 
  `Titel`            varchar(255) NOT NULL, 
  `Aufgabenstellung` text NOT NULL, 
  `Done`             tinyint NOT NULL, 
  `TerminID`         int(10), 
  PRIMARY KEY (`ID`), 
  UNIQUE INDEX (`ID`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Member` (
  `User`        varchar(255) NOT NULL, 
  `Project`     varchar(255) NOT NULL, 
  `ProjectRole` varchar(255) NOT NULL, 
  PRIMARY KEY (`User`, 
  `Project`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `TODO` (
  `MemberUser`    varchar(255) NOT NULL, 
  `MemberProject` varchar(255) NOT NULL, 
  `TaskID`        int(10) NOT NULL, 
  PRIMARY KEY (`MemberUser`, 
  `MemberProject`, 
  `TaskID`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Termin` (
  `ID`     int(10) NOT NULL AUTO_INCREMENT, 
  `Termin` date NOT NULL, 
  PRIMARY KEY (`ID`), 
  UNIQUE INDEX (`ID`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `CommentProject` (
  `CommentID` int(10) NOT NULL, 
  `Project`   varchar(255) NOT NULL, 
  PRIMARY KEY (`CommentID`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `CommentSourcecode` (
  `CommentID`    int(10) NOT NULL, 
  `SourcecodeID` int(10) NOT NULL, 
  PRIMARY KEY (`CommentID`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `CommentDocument` (
  `CommentID`  int(10) NOT NULL, 
  `DocumentID` int(10) NOT NULL, 
  PRIMARY KEY (`CommentID`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `CommentTask` (
  `CommentID` int(10) NOT NULL, 
  `TaskID`    int(10) NOT NULL, 
  PRIMARY KEY (`CommentID`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `ProjectRoles` (
  `Role`                           varchar(255) NOT NULL, 
  `CommentDocuAction`              tinyint(1) DEFAULT 0 NOT NULL, 
  `CommentSourceAction`            tinyint(1) DEFAULT 0 NOT NULL, 
  `CommentTaskAction`              tinyint(1) DEFAULT 0 NOT NULL, 
  `CommentProjectAction`           tinyint(1) NOT NULL, 
  `DeleteCommentAction`            tinyint(1) DEFAULT 0 NOT NULL, 
  `ShowAllComments41DocuAction`    tinyint(1) NOT NULL, 
  `ShowAllComments41SourceAction`  tinyint(1) NOT NULL, 
  `ShowAllComments41TaskAction`    tinyint(1) NOT NULL, 
  `ShowAllComments41ProjectAction` tinyint(1) NOT NULL, 
  `UpdateCommentAction`            tinyint(1) NOT NULL, 
  `AddNewDocuAction`               tinyint(1) DEFAULT 0 NOT NULL, 
  `DeleteDocuAction`               tinyint(1) DEFAULT 0 NOT NULL, 
  `DownloadDocuAction`             tinyint(1) DEFAULT 0 NOT NULL, 
  `ShowDocuAction`                 tinyint(1) NOT NULL, 
  `ShowAllDocuAction`              tinyint(1) DEFAULT 0 NOT NULL, 
  `UpdateDocuAction`               tinyint(1) NOT NULL, 
  `AddMemberAction`                tinyint(1) DEFAULT 0 NOT NULL, 
  `DeleteMemberAction`             tinyint(1) NOT NULL, 
  `ShowAllMemberAction`            tinyint(1) NOT NULL, 
  `AddNewSourceAction`             tinyint(1) NOT NULL, 
  `DeleteSourceAction`             tinyint(1) NOT NULL, 
  `DownloadSourceAction`           tinyint(1) NOT NULL, 
  `ShowSourceAction`               tinyint(1) NOT NULL, 
  `ShowAllSourceAction`            tinyint(1) NOT NULL, 
  `UpdateSourceAction`             tinyint(1) NOT NULL, 
  `AddNewTaskAction`               tinyint(1) NOT NULL, 
  `DeleteTaskAction`               tinyint(1) NOT NULL, 
  `ShowAllTasksAction`             tinyint(1) NOT NULL, 
  `ShowAllOwnTasksAction`          tinyint(1) NOT NULL, 
  `UpdateTaskAction`               tinyint(1) NOT NULL, 
  `DeleteProjectAction`            tinyint(1) NOT NULL, 
  PRIMARY KEY (`Role`)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `GlobalRoles` (
  `Role`                           varchar(255) NOT NULL, 
  `AddNewProjectAction`            tinyint(1) DEFAULT 0 NOT NULL, 
  `DeleteProjectAction`            tinyint(1) NOT NULL, 
  `ShowProjectAction`              tinyint(1) NOT NULL, 
  `SearchProjectsAction`           tinyint(1) NOT NULL, 
  `ShowAllProjectsAction`          tinyint(1) NOT NULL, 
  `ShowAllOwnProjectAction`        tinyint(1) NOT NULL, 
  `DeleteUserAction`               tinyint(1) NOT NULL, 
  `ShowUserSettingsAction`         tinyint(1) NOT NULL, 
  `UpdateUserSettingsAction`       tinyint(1) NOT NULL, 
  `ShowUserInfoAction`             tinyint(1) NOT NULL, 
  `SearchUserAction`               tinyint(1) NOT NULL, 
  `ShowAllUserAction`              tinyint(1) NOT NULL, 
  `LoginAction`                    tinyint(1) NOT NULL, 
  `LogoutAction`                   tinyint(1) NOT NULL, 
  `RegisterAction`                 tinyint(1) NOT NULL, 
  `CommentDocuAction`              tinyint(1) DEFAULT 0 NOT NULL, 
  `CommentSourceAction`            tinyint(1) DEFAULT 0 NOT NULL, 
  `CommentTaskAction`              tinyint(1) DEFAULT 0 NOT NULL, 
  `CommentProjectAction`           tinyint(1) NOT NULL, 
  `DeleteCommentAction`            tinyint(1) DEFAULT 0 NOT NULL, 
  `ShowAllComments41DocuAction`    tinyint(1) NOT NULL, 
  `ShowAllComments41SourceAction`  tinyint(1) NOT NULL, 
  `ShowAllComments41TaskAction`    tinyint(1) NOT NULL, 
  `ShowAllComments41ProjectAction` tinyint(1) NOT NULL, 
  `UpdateCommentAction`            tinyint(1) NOT NULL, 
  `AddNewDocuAction`               tinyint(1) DEFAULT 0 NOT NULL, 
  `DeleteDocuAction`               tinyint(1) DEFAULT 0 NOT NULL, 
  `DownloadDocuAction`             tinyint(1) DEFAULT 0 NOT NULL, 
  `ShowDocuAction`                 tinyint(1) NOT NULL, 
  `ShowAllDocuAction`              tinyint(1) DEFAULT 0 NOT NULL, 
  `UpdateDocuAction`               tinyint(1) NOT NULL, 
  `AddMemberAction`                tinyint(1) DEFAULT 0 NOT NULL, 
  `DeleteMemberAction`             tinyint(1) NOT NULL, 
  `ShowAllMemberAction`            tinyint(1) NOT NULL, 
  `AddNewSourceAction`             tinyint(1) NOT NULL, 
  `DeleteSourceAction`             tinyint(1) NOT NULL, 
  `DownloadSourceAction`           tinyint(1) NOT NULL, 
  `ShowSourceAction`               tinyint(1) NOT NULL, 
  `ShowAllSourceAction`            tinyint(1) NOT NULL, 
  `UpdateSourceAction`             tinyint(1) NOT NULL, 
  `AddNewTaskAction`               tinyint(1) NOT NULL, 
  `DeleteTaskAction`               tinyint(1) NOT NULL, 
  `ShowAllTasksAction`             tinyint(1) NOT NULL, 
  `ShowAllOwnTasksAction`          tinyint(1) NOT NULL, 
  `UpdateTaskAction`               tinyint(1) NOT NULL, 
  `DeleteProjectAction2`           tinyint(1) NOT NULL, 
  PRIMARY KEY (`Role`)) ENGINE=InnoDB CHARACTER SET UTF8;
ALTER TABLE `Member` ADD INDEX `FKMember111780` (`User`), ADD CONSTRAINT `FKMember111780` FOREIGN KEY (`User`) REFERENCES `User` (`LoginName`) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE `Member` ADD INDEX `FKMember203878` (`Project`), ADD CONSTRAINT `FKMember203878` FOREIGN KEY (`Project`) REFERENCES `Project` (`Name`) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE `Comment` ADD INDEX `FKComment124517` (`User`), ADD CONSTRAINT `FKComment124517` FOREIGN KEY (`User`) REFERENCES `User` (`LoginName`) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE `ICQ` ADD INDEX `FKICQ715377` (`UserLoginName`), ADD CONSTRAINT `FKICQ715377` FOREIGN KEY (`UserLoginName`) REFERENCES `User` (`LoginName`) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE `Skype` ADD INDEX `FKSkype602880` (`UserLoginName`), ADD CONSTRAINT `FKSkype602880` FOREIGN KEY (`UserLoginName`) REFERENCES `User` (`LoginName`) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE `Telefon` ADD INDEX `FKTelefon936160` (`UserLoginName`), ADD CONSTRAINT `FKTelefon936160` FOREIGN KEY (`UserLoginName`) REFERENCES `User` (`LoginName`) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE `Sourcecode` ADD INDEX `FKSourcecode392374` (`Project`), ADD CONSTRAINT `FKSourcecode392374` FOREIGN KEY (`Project`) REFERENCES `Project` (`Name`) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE `Document` ADD INDEX `FKDocument497399` (`Project`), ADD CONSTRAINT `FKDocument497399` FOREIGN KEY (`Project`) REFERENCES `Project` (`Name`) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE `Task` ADD INDEX `FKTask263977` (`Project`), ADD CONSTRAINT `FKTask263977` FOREIGN KEY (`Project`) REFERENCES `Project` (`Name`) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE `TODO` ADD INDEX `FKTODO442996` (`MemberUser`, `MemberProject`), ADD CONSTRAINT `FKTODO442996` FOREIGN KEY (`MemberUser`, `MemberProject`) REFERENCES `Member` (`User`, `Project`) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE `TODO` ADD INDEX `FKTODO825529` (`TaskID`), ADD CONSTRAINT `FKTODO825529` FOREIGN KEY (`TaskID`) REFERENCES `Task` (`ID`) ON DELETE Cascade;
ALTER TABLE `Task` ADD INDEX `FKTask626088` (`TerminID`), ADD CONSTRAINT `FKTask626088` FOREIGN KEY (`TerminID`) REFERENCES `Termin` (`ID`) ON DELETE Set null;
ALTER TABLE `CommentProject` ADD INDEX `FKCommentPro655506` (`CommentID`), ADD CONSTRAINT `FKCommentPro655506` FOREIGN KEY (`CommentID`) REFERENCES `Comment` (`ID`) ON DELETE Cascade;
ALTER TABLE `CommentProject` ADD INDEX `FKCommentPro755040` (`Project`), ADD CONSTRAINT `FKCommentPro755040` FOREIGN KEY (`Project`) REFERENCES `Project` (`Name`) ON UPDATE Cascade ON DELETE Cascade;
ALTER TABLE `CommentSourcecode` ADD INDEX `FKCommentSou638505` (`CommentID`), ADD CONSTRAINT `FKCommentSou638505` FOREIGN KEY (`CommentID`) REFERENCES `Comment` (`ID`) ON DELETE Cascade;
ALTER TABLE `CommentSourcecode` ADD INDEX `FKCommentSou273811` (`SourcecodeID`), ADD CONSTRAINT `FKCommentSou273811` FOREIGN KEY (`SourcecodeID`) REFERENCES `Sourcecode` (`ID`) ON DELETE Cascade;
ALTER TABLE `CommentDocument` ADD INDEX `FKCommentDoc222377` (`CommentID`), ADD CONSTRAINT `FKCommentDoc222377` FOREIGN KEY (`CommentID`) REFERENCES `Comment` (`ID`) ON DELETE Cascade;
ALTER TABLE `CommentDocument` ADD INDEX `FKCommentDoc892377` (`DocumentID`), ADD CONSTRAINT `FKCommentDoc892377` FOREIGN KEY (`DocumentID`) REFERENCES `Document` (`ID`) ON DELETE Cascade;
ALTER TABLE `CommentTask` ADD INDEX `FKCommentTas532422` (`CommentID`), ADD CONSTRAINT `FKCommentTas532422` FOREIGN KEY (`CommentID`) REFERENCES `Comment` (`ID`) ON DELETE Cascade;
ALTER TABLE `CommentTask` ADD INDEX `FKCommentTas995932` (`TaskID`), ADD CONSTRAINT `FKCommentTas995932` FOREIGN KEY (`TaskID`) REFERENCES `Task` (`ID`) ON DELETE Cascade;
INSERT INTO `User`
  (`LoginName`, `Password`, `Vorname`, `Nachname`, `Sprache`, `GlobalRole`) 
VALUES 
  ('UserLoginName', 'Password', 'Vorname', 'Nachname', 'Sprache', 'Member');
INSERT INTO `Project`
  (`Name`, `Status`) 
VALUES 
  ('ProjectName', 'Status');
INSERT INTO `Sourcecode`
  (`ID`, `Project`, `Dateiname`) 
VALUES 
  (1, 'ProjectName', 'Dateiname');
INSERT INTO `Document`
  (`ID`, `Project`, `Dateiname`) 
VALUES 
  (1, 'ProjectName', 'Dateiname');
INSERT INTO `ICQ`
  (`UserLoginName`, `ICQNumber`) 
VALUES 
  ('UserLoginName', 123456789);
INSERT INTO `Skype`
  (`UserLoginName`, `SkypeName`) 
VALUES 
  ('UserLoginName', 'SkypeName');
INSERT INTO `Telefon`
  (`UserLoginName`, `TelNumber`) 
VALUES 
  ('UserLoginName', 12345678);
INSERT INTO `Comment`
  (`ID`, `User`, `Entry`) 
VALUES 
  (1, 'UserLoginName', 'Entry');
INSERT INTO `Task`
  (`ID`, `Project`, `Titel`, `Aufgabenstellung`, `Done`, `TerminID`) 
VALUES 
  (1, 'ProjectName', 'Titel', 'Aufgabenstellung', 1, null);
INSERT INTO `Member`
  (`User`, `Project`, `ProjectRole`) 
VALUES 
  ('UserLoginName', 'ProjectName', 'Leader');
INSERT INTO `TODO`
  (`MemberUser`, `MemberProject`, `TaskID`) 
VALUES 
  ('UserLoginName', 'ProjectName', 1);
INSERT INTO `CommentProject`
  (`CommentID`, `Project`) 
VALUES 
  (1, 'ProjectName');
INSERT INTO `CommentSourcecode`
  (`SourcecodeID`, `CommentID`) 
VALUES 
  (1, 1);
INSERT INTO `CommentDocument`
  (`CommentID`, `DocumentID`) 
VALUES 
  (1, 1);
INSERT INTO `CommentTask`
  (`CommentID`, `TaskID`) 
VALUES 
  (1, 1);
INSERT INTO `ProjectRoles`
  (`Role`, `CommentDocuAction`, `CommentSourceAction`, `CommentTaskAction`, `CommentProjectAction`, `DeleteCommentAction`, `ShowAllComments41DocuAction`, `ShowAllComments41SourceAction`, `ShowAllComments41TaskAction`, `ShowAllComments41ProjectAction`, `UpdateCommentAction`, `AddNewDocuAction`, `DeleteDocuAction`, `DownloadDocuAction`, `ShowDocuAction`, `ShowAllDocuAction`, `UpdateDocuAction`, `AddMemberAction`, `DeleteMemberAction`, `ShowAllMemberAction`, `AddNewSourceAction`, `DeleteSourceAction`, `DownloadSourceAction`, `ShowSourceAction`, `ShowAllSourceAction`, `UpdateSourceAction`, `AddNewTaskAction`, `DeleteTaskAction`, `ShowAllTasksAction`, `ShowAllOwnTasksAction`, `UpdateTaskAction`, `DeleteProjectAction`) 
VALUES 
  ('Leader', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `ProjectRoles`
  (`Role`, `CommentDocuAction`, `CommentSourceAction`, `CommentTaskAction`, `CommentProjectAction`, `DeleteCommentAction`, `ShowAllComments41DocuAction`, `ShowAllComments41SourceAction`, `ShowAllComments41TaskAction`, `ShowAllComments41ProjectAction`, `UpdateCommentAction`, `AddNewDocuAction`, `DeleteDocuAction`, `DownloadDocuAction`, `ShowDocuAction`, `ShowAllDocuAction`, `UpdateDocuAction`, `AddMemberAction`, `DeleteMemberAction`, `ShowAllMemberAction`, `AddNewSourceAction`, `DeleteSourceAction`, `DownloadSourceAction`, `ShowSourceAction`, `ShowAllSourceAction`, `UpdateSourceAction`, `AddNewTaskAction`, `DeleteTaskAction`, `ShowAllTasksAction`, `ShowAllOwnTasksAction`, `UpdateTaskAction`, `DeleteProjectAction`) 
VALUES 
  ('Member', 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0);
INSERT INTO `GlobalRoles`
  (`Role`, `AddNewProjectAction`, `DeleteProjectAction`, `ShowProjectAction`, `SearchProjectsAction`, `ShowAllProjectsAction`, `ShowAllOwnProjectAction`, `DeleteUserAction`, `ShowUserSettingsAction`, `UpdateUserSettingsAction`, `ShowUserInfoAction`, `SearchUserAction`, `ShowAllUserAction`, `LoginAction`, `LogoutAction`, `RegisterAction`, `CommentDocuAction`, `CommentSourceAction`, `CommentTaskAction`, `CommentProjectAction`, `DeleteCommentAction`, `ShowAllComments41DocuAction`, `ShowAllComments41SourceAction`, `ShowAllComments41TaskAction`, `ShowAllComments41ProjectAction`, `UpdateCommentAction`, `AddNewDocuAction`, `DeleteDocuAction`, `DownloadDocuAction`, `ShowDocuAction`, `ShowAllDocuAction`, `UpdateDocuAction`, `AddMemberAction`, `DeleteMemberAction`, `ShowAllMemberAction`, `AddNewSourceAction`, `DeleteSourceAction`, `DownloadSourceAction`, `ShowSourceAction`, `ShowAllSourceAction`, `UpdateSourceAction`, `AddNewTaskAction`, `DeleteTaskAction`, `ShowAllTasksAction`, `ShowAllOwnTasksAction`, `UpdateTaskAction`, `DeleteProjectAction2`) 
VALUES 
  ('Admin', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `GlobalRoles`
  (`Role`, `AddNewProjectAction`, `DeleteProjectAction`, `ShowProjectAction`, `SearchProjectsAction`, `ShowAllProjectsAction`, `ShowAllOwnProjectAction`, `DeleteUserAction`, `ShowUserSettingsAction`, `UpdateUserSettingsAction`, `ShowUserInfoAction`, `SearchUserAction`, `ShowAllUserAction`, `LoginAction`, `LogoutAction`, `RegisterAction`, `CommentDocuAction`, `CommentSourceAction`, `CommentTaskAction`, `CommentProjectAction`, `DeleteCommentAction`, `ShowAllComments41DocuAction`, `ShowAllComments41SourceAction`, `ShowAllComments41TaskAction`, `ShowAllComments41ProjectAction`, `UpdateCommentAction`, `AddNewDocuAction`, `DeleteDocuAction`, `DownloadDocuAction`, `ShowDocuAction`, `ShowAllDocuAction`, `UpdateDocuAction`, `AddMemberAction`, `DeleteMemberAction`, `ShowAllMemberAction`, `AddNewSourceAction`, `DeleteSourceAction`, `DownloadSourceAction`, `ShowSourceAction`, `ShowAllSourceAction`, `UpdateSourceAction`, `AddNewTaskAction`, `DeleteTaskAction`, `ShowAllTasksAction`, `ShowAllOwnTasksAction`, `UpdateTaskAction`, `DeleteProjectAction2`) 
VALUES 
  ('Member', 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
