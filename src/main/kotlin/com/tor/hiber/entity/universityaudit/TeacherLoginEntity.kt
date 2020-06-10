package com.tor.hiber.entity.universityaudit

import com.tor.hiber.entity.BaseAuditEntity
import javax.persistence.*

@Entity
@Table(name = "TEACHERLOGIN", schema = "UNIVERSITYAUDIT")
class TeacherLoginEntity(

        @Column(name = "HUMANID", nullable = false)
        var humanId: Int? = null,

        @Column(name = "LOGIN", nullable = false, length = 20)
        var login: String? = null,

        @Column(name = "PASSWORD", nullable = false, length = 50)
        var password: String? = null,

        //    @get:OneToMany(mappedBy = "refTEACHERLOGINEntity")
//    var refTEACHERGROUPTLLINKEntities: List<TEACHERGROUPTLLINKEntity>? = null
        //    @get:ManyToOne(fetch = FetchType.LAZY)
//    @get:JoinColumn(name = "HUMANID", referencedColumnName = "HUMANID")
//    @get:Column(name = "HUMANID", nullable = false)
//    var humanid: Int? = null
        /* @get:OneToMany(mappedBy = "refTEACHERLOGINEntity")
         var refTLGROUPLINKEntities: List<TLGROUPLINKEntity>? = null*/

        @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        @JoinTable(schema = "UNIVERSITYAUDIT", name = "TLGROUPLINK",
                joinColumns = [JoinColumn(name = "TLOGINID")],
                inverseJoinColumns = [JoinColumn(name = "GROUPID")])
        var roleGroups: MutableSet<TLGroupEntity> = mutableSetOf(),

        /*  @get:ManyToMany
          @get:JoinTable(schema = "UNIVERSITYAUDIT", name = "TEACHERGROUP_TL_LINK",
                  joinColumns = [JoinColumn(name = "TLID", referencedColumnName = "ID")],
                  inverseJoinColumns = [JoinColumn(name = "TGROUPID", referencedColumnName = "GROUPID")]) */
        @ManyToMany(mappedBy = "teacherlogins")
        var teacherGroups: MutableSet<TeacherGroupEntity> = mutableSetOf()
) : BaseAuditEntity<Int>() {
    fun addRoleGroup(block: TeacherLoginEntity.() -> TLGroupEntity) {
        roleGroups.add(block())
    }

    fun setRoleGroups(block: TeacherLoginEntity.() -> MutableSet<TLGroupEntity>) {
        roleGroups.clear()
        roleGroups.addAll(block())
    }

    fun addTeacherGroup(block: TeacherLoginEntity.() -> TeacherGroupEntity) {
        teacherGroups.add(block())
    }

    fun setTeacherGroups(block: TeacherLoginEntity.() -> MutableSet<TeacherGroupEntity>) {
        teacherGroups.clear()
        teacherGroups.addAll(block())
    }
}