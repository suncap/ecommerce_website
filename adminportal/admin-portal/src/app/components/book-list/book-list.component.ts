import { Component, OnInit } from '@angular/core';
import { Book} from '../../models/book'
import { GetbooklistserviceService } from '../../services/getbooklistservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  private selecetdBook: Book;
  private checked: boolean;
  private bookList: Book[];
  private allChcked: boolean;
  private removeBookList:Book[] = new Array();
  constructor(
    private getBookListService: GetbooklistserviceService,
    private router: Router) { }

  ngOnInit() {
    this.getBookListService.getBookList().subscribe(
      res => {
        console.log(res.json());
        this.bookList = res.json();
      },
      error => {
        console.log(error);
      }
    );
  }

}
