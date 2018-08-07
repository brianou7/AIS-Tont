import { TontFrontPage } from './app.po';

describe('tont-front App', function() {
  let page: TontFrontPage;

  beforeEach(() => {
    page = new TontFrontPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
