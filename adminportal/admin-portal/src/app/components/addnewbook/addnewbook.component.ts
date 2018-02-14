import { Component, OnInit } from '@angular/core';
import { Book } from '../../models/book';

@Component({
  selector: 'app-addnewbook',
  templateUrl: './addnewbook.component.html',
  styleUrls: ['./addnewbook.component.css']
})
export class AddnewbookComponent implements OnInit {

  private newBook: Book = new Book();
  private bookAdded: boolean;
  constructor() { }

  ngOnInit() {
  }

}
