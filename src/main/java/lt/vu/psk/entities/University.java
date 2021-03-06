/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.psk.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Povilas
 */
@Entity
@Table(name = "UNIVERSITY")
@NamedQueries({
    @NamedQuery(name = "University.findAll", query = "SELECT u FROM University u"),
    @NamedQuery(name = "University.findById", query = "SELECT u FROM University u WHERE u.id = :id"),
    @NamedQuery(name = "University.findByTitle", query = "SELECT u FROM University u WHERE u.title = :title"),
    @NamedQuery(name = "University.findByOptLockVersion", query = "SELECT u FROM University u WHERE u.optLockVersion = :optLockVersion"),
    @NamedQuery(name = "University.findByUniveristyId", query = "SELECT u FROM University u WHERE u.univeristyId = :univeristyId")})
public class University implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "OPT_LOCK_VERSION")
    private Integer optLockVersion;
    @Size(max = 20)
    @Column(name = "UNIVERISTY_ID")
    private String univeristyId;
    @OneToMany(mappedBy = "universityId")
    private List<Student> studentList;

    public University() {
    }

    public University(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOptLockVersion() {
        return optLockVersion;
    }

    public void setOptLockVersion(Integer optLockVersion) {
        this.optLockVersion = optLockVersion;
    }

    public String getUniveristyId() {
        return univeristyId;
    }

    public void setUniveristyId(String univeristyId) {
        this.univeristyId = univeristyId;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (univeristyId != null ? univeristyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        University other = (University) object;
        return this.univeristyId.equals(other.univeristyId);
    }

    @Override
    public String toString() {
        return "lt.vu.psk.entities.University[ id=" + id + " ]";
    }
    
}
