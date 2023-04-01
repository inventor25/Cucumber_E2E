@OdaOlusturma
Feature:room_create1

  Scenario Outline: TC01_room_create
    Given Kullanici "https://www.medunna.com/" gider
    When Kullanici giris bölümü sembolüne tiklar
    And Kullanici Sign In butonuna tiklar
    And Kullanici Username "<username>" girer
    And Kullanici Password "<password>" girer
    And Kullanici altta ki sign in butonuna tıklar
    Then Kullanici basarili giris yaptigini dogrular
    Then close the application

    Examples: Kullanici_Bilgileri
      | username | password |
      | qa_ahmet | qa.ahmet |


