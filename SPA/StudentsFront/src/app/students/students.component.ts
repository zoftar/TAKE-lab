import { Component, OnInit } from '@angular/core';
import { Student } from '../student';
import {StudentService} from '../student.service';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  students: Student[];


  constructor(private studentService: StudentService) { }

  ngOnInit() {
    this.getStudents();
  }

  getStudents(): void {
    this.studentService.getStudents()
    .subscribe(students => this.students = students);
    }
  
    create(index: number, firstName: string, lastName: string): void {
      this.studentService.createStudent({ index: index,
      firstName: firstName,
     lastName: lastName } as Student)
      .subscribe(student => { this.students.push(student); });
     }

     delete(student: Student): void {
      this.students = this.students.filter(s => s.id !== student.id);
      this.studentService.deleteStudent(student).subscribe();
      }
     
     

}
