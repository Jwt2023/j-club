package com.jClub.subject.infra.basic.service;

import com.jClub.subject.common.entity.PageResult;
import com.jClub.subject.infra.basic.entity.SubjectInfoEs;

public interface SubjectEsService {

    boolean insert(SubjectInfoEs subjectInfoEs);

    PageResult<SubjectInfoEs> querySubjectList(SubjectInfoEs subjectInfoEs);

}
