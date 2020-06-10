package com.tor.hiber.entity.universityaudit

import com.tor.hiber.entity.BaseAuditEntity
import javax.persistence.*

@Entity
@Table(name = "TEACHERGROUP", schema = "UNIVERSITYAUDIT", catalog = "")
class TeacherGroupEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teachergroup_seq")
        @SequenceGenerator(name = "teachergroup_seq", sequenceName = "teachergroup_seq", schema = "UNIVERSITYAUDIT")
        @Column(name = "GROUPID", nullable = false, insertable = false, updatable = false)
        var groupId: Long? = null,

        @Basic
        @Column(name = "NAME", nullable = false)
        var name: String? = null,
        @ManyToMany
        @JoinTable(schema = "UNIVERSITYAUDIT", name = "TEACHERGROUP_TL_LINK",
                joinColumns = [JoinColumn(name = "TGROUPID")],
                inverseJoinColumns = [JoinColumn(name = "TLID")])
        var teacherlogins: MutableSet<TeacherLoginEntity>? = null
):BaseAuditEntity<Int>()
