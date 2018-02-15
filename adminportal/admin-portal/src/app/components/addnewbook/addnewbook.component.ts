import { Component, OnInit } from '@angular/core';
import { Book } from '../../models/book';
import { AddBookService } from '../../services/add-book.service';

@Component({
  selector: 'app-addnewbook',
  templateUrl: './addnewbook.component.html',
  styleUrls: ['./addnewbook.component.css']
})
export class AddnewbookComponent implements OnInit {

  private newBook: Book = new Book();
  private bookAdded: boolean;
  constructor(private bookService:AddBookService) { }

  onSubmit(){
    this.bookService.sendBook(this.newBook).subscribe(
      res => {
        this.bookAdded = true;
        this.newBook = new Book();
        this.newBook.active = true;
        this.newBook.category = "Management";
        this.newBook.language = "english";
        this.newBook.format = "paperback";
      },
      error =>{
        console.log(error);
      }
    );
  }

  ngOnInit() {
    this.newBook.active = true;
    this.newBook.category = "Management";
    this.newBook.language = "english";
    this.newBook.format = "paperback";
  }
}
