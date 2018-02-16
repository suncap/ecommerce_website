import { TestBed, inject } from '@angular/core/testing';

import { GetbooklistserviceService } from './getbooklistservice.service';

describe('GetbooklistserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GetbooklistserviceService]
    });
  });

  it('should be created', inject([GetbooklistserviceService], (service: GetbooklistserviceService) => {
    expect(service).toBeTruthy();
  }));
});
