import { TestBed, inject } from '@angular/core/testing';

import { EditBootService } from './edit-boot.service';

describe('EditBootService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EditBootService]
    });
  });

  it('should be created', inject([EditBootService], (service: EditBootService) => {
    expect(service).toBeTruthy();
  }));
});
