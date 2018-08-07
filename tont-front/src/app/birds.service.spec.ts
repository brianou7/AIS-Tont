/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { BirdsService } from './birds.service';

describe('BirdsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BirdsService]
    });
  });

  it('should ...', inject([BirdsService], (service: BirdsService) => {
    expect(service).toBeTruthy();
  }));
});
