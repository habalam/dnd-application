import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CharacterServiceComponent } from './character-service.component';

describe('CharacterServiceComponent', () => {
  let component: CharacterServiceComponent;
  let fixture: ComponentFixture<CharacterServiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CharacterServiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CharacterServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
