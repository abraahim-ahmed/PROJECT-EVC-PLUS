import java.time.LocalDateTime;
import java.util.Scanner;


public class Project_EVCPLUS {

    private static double balance = 540.0;
    private static String pin = "1100";
    private static String lastTransferNumber = " ";
    private static double lastTransferAmount = 0.0;
    private static String[] lastThreeActions = new String[3];
    private static String language = "Somali";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO EVC PLUS");
        System.out.print("Fadlan Geli zipcode:");
        String us= scanner.nextLine();

        if (!us.equals("*770#")) {
            System.out.println("Waa qald zipcodka. Fadlan Geli: *770#");
            scanner.close();
            return;
        }

        // PIN verification
        System.out.print("Geli PIN-kaaga: ");
        String enp = scanner.nextLine();

        if (!enp.equals(pin)) {
            System.out.println("PIN-kaaga waa khalad.");
            scanner.close();
            return;
        }
        //Services of evc plus
        boolean running = true;
        while (running) {
            System.out.println("\nMenu-ga EVC+:");
            System.out.println("1. Itus Haraaga");
            System.out.println("2. Kaarka hadalka");
            System.out.println("3. Bixi Biil");
            System.out.println("4. U wareeji Evc-Plus");
            System.out.println("5. Warbixin kooban");
            System.out.println("6. Salaam Bank");
            System.out.println("7. Maareynta");
            System.out.println("8. Bill payment");
            System.out.println("9. Ka bax");
            System.out.print("Geli doorashada (1-9): ");

            int dro = scanner.nextInt();
            scanner.nextLine();
            //qaybta haraaga
            if (dro == 1) {
                System.out.println("\nHaraagaagu waa: $" + balance);
                addAction("Balansiga eegis: $" + balance);
            } else if (dro == 2) {
                kaarkaHadalka(scanner);
            } else if (dro == 3) {
                bixiBiilka(scanner);
            } else if (dro == 4) {
                UwareejiEVCPlus(scanner);
            } else if (dro == 5) {
                WarbixinKooban(scanner);
            } else if (dro == 6) {
                salaamBank(scanner);
            } else if (dro == 7) {
                Maareynta(scanner);
            } else if (dro == 8) {
                billPyment(scanner);
            } else if (dro == 9) {
                System.out.println("Macsalaama!");
                running = false;
            } else {
                System.out.println("Doorashada aad dooratay ma saxan tahay");
            }
        }
    }

    private static void addAction(String action) {
        // Shift existing actions
        lastThreeActions[2] = lastThreeActions[1];
        lastThreeActions[1] = lastThreeActions[0];
        lastThreeActions[0] = action;
    }

    private static void kaarkaHadalka(Scanner scanner) {
        //part two of services of evc plus
        System.out.println("\nKaarka Hadalka:");
        System.out.println("1. Ku shub Airtime");
        System.out.println("2. Ugu shub Airtime");
        System.out.println("3. MIFI Packages");
        System.out.println("4. Ku shubo Internet");
        System.out.println("5. Ugu shub qof kale");
        System.out.print("Geli doorashada (1-5): ");

        int ku = scanner.nextInt();
        scanner.nextLine();

        switch (ku) {
            case 1:
                //ku shubo airTime
                System.out.print("Fadlan gali lacagta: $");
                double lcg = scanner.nextDouble();
                scanner.nextLine();

                if (lcg <= 0) {
                    System.out.println("Haragaaga ku guma filna");
                    break;
                }

                System.out.println("Ma hubtaa inaad $" + lcg + " ugu shubtid?");
                System.out.println("1. Haa");
                System.out.println("2. Maya");
                System.out.print("Geli doorashada: ");
                int yn = scanner.nextInt();
                scanner.nextLine();

                if (yn == 1) {
                    if (lcg <= balance) {
                        balance -= lcg;
                        System.out.println("Waxaad ku shubtay $" + lcg + " airtime.");
                        System.out.println("Haraaga cusub: $" + balance);
                        addAction("Ku shub airtime: $" + lcg);
                    } else {
                        System.out.println("Haragaaga kuguma filna");
                    }
                } else {
                    System.out.println("Macsalaamo.");
                }
                break;

            case 2:
                //ugu shub airTime
                System.out.print("Fadlan gali mobile-ka: ");
                String ugu = scanner.nextLine();

                System.out.print("Fadlan gali lacagta: $");
                double lg = scanner.nextDouble();
                scanner.nextLine();

                if (lg <= 0) {
                    System.out.println("Haraagaga kuguma filna");
                    break;
                }

                System.out.println("Ma hubtaa inaad $" + lg + " ugu shubtid number-ka " + ugu + "?");
                System.out.println("1. Haa");
                System.out.println("2. Maya");
                System.out.print("Geli doorashada: ");
                int ny = scanner.nextInt();
                scanner.nextLine();

                if (ny == 1) {
                    if (lg <= balance) {
                        balance -= lg;
                        lastTransferNumber = ugu;
                        lastTransferAmount = lg;
                        System.out.println("Waxaad ugu shubtay $" + lg + " numberka " + ugu);
                        System.out.println("Haraaga cusub: $" + balance);
                        addAction("U dir airtime $" + lg + " to " + ugu);
                    } else {
                        System.out.println("Haraagaaga kuguma filna");
                    }
                } else {
                    System.out.println("Macsalaamo.");
                }
                break;

            case 3:
                //Mifi packages
                System.out.println("\nMIFI Packages:");
                System.out.println("1. $10 - 1GB (30 maalmood)");
                System.out.println("2. $20 - 3GB (30 maalmood)");
                System.out.println("3. $30 - 5GB (30 maalmood)");
                System.out.println("4. $50 - 10GB (30 maalmood)");
                System.out.print("Geli doorashada (1-4): ");
                int mf = scanner.nextInt();
                scanner.nextLine();

                double mp = 0;
                String mpk = "";

                switch (mf) {
                    case 1:
                        mp = 10;
                        mpk = "1GB";
                        break;
                    case 2:
                        mp = 20;
                        mpk = "3GB";
                        break;
                    case 3:
                        mp = 30;
                        mpk = "5GB";
                        break;
                    case 4:
                        mp = 50;
                        mpk = "10GB";
                        break;
                    default:
                        System.out.println("Doorashada aad dooratay ma saxan tahay");
                        break;
                }

                if (mp > 0) {
                    System.out.println("Ma hubtaa inaad iibsato baakad " + mpk + " $" + mp + "?");
                    System.out.println("1. Haa");
                    System.out.println("2. Maya");
                    System.out.print("Geli doorashada: ");
                    int cm = scanner.nextInt();
                    scanner.nextLine();

                    if (cm == 1) {
                        if (mp <= balance) {
                            balance -= mp;
                            System.out.println("Waad ku guuleysatay! Baakadka " + mpk + " waa la shubay.");
                            System.out.println("Haraaga cusub: $" + balance);
                            addAction("MIFI " + mpk + " $" + mp);
                        } else {
                            System.out.println("Lacag kugu filan ma aha");
                        }
                    } else {
                        System.out.println("Waa la joojiyay");
                    }
                }
                break;

            case 4:
                //ku shubo internet
                System.out.println("\nKu shubo Internet:");
                System.out.println("1. Isbuucle (weekly)");
                System.out.println("2. TIME BASED PACKAGES");
                System.out.println("3. DATA");
                System.out.println("4. Maalinle (daily)");
                System.out.println("5. Bille");
                System.out.print("Geli doorashada (1-5): ");
                int in = scanner.nextInt();
                scanner.nextLine();

                switch (in) {
                    case 1:
                        //isbuucle
                        System.out.println("\nIsbuucle Packages:");
                        System.out.println("1. $5 - 500MB (7 maalmood)");
                        System.out.println("2. $10 - 1GB (7 maalmood)");
                        System.out.println("3. $15 - 2GB (7 maalmood)");
                        System.out.print("Geli doorashada (1-3): ");
                        int wk = scanner.nextInt();
                        scanner.nextLine();

                        double wp = 0;
                        String wpk = "";

                        if (wk == 1) {
                            wp = 5;
                            wpk = "500MB";
                        } else if (wk == 2) {
                            wp = 10;
                            wpk = "1GB";
                        } else if (wk == 3) {
                            wp = 15;
                            wpk = "2GB";
                        } else {
                            System.out.println("Doorashada aad dooratay ma saxan tahay");
                            break;
                        }

                        System.out.println("Ma hubtaa inaad iibsato baakad " + wpk + " $" + wp + "?");
                        System.out.println("1. Haa");
                        System.out.println("2. Maya");
                        System.out.print("Geli doorashada: ");
                        int cw = scanner.nextInt();
                        scanner.nextLine();

                        if (cw == 1) {
                            if (wp <= balance) {
                                balance -= wp;
                                System.out.println("Waad ku guuleysatay! Baakadka " + wpk + " waa la shubay.");
                                System.out.println("Haraaga cusub: $" + balance);
                                addAction("Internet weekly " + wpk + " $" + wp);
                            } else {
                                System.out.println("haraagaga kuguma filna");
                            }
                        } else {
                            System.out.println("Macsalaamo.");
                        }
                        break;

                    default:
                        System.out.println("Doorashada aad dooratay ma saxan tahay");
                        break;
                }
                break;

            default:
                System.out.println("Doorashada aad dooratay ma saxan tahay");
                break;
        }
    }

    //qaybta bixi biilka
    private static void bixiBiilka(Scanner scanner) {
        System.out.println("\nBixi Biil:");
        System.out.println("1. Post paid");
        System.out.println("2. Ku iibso");
        System.out.print("Geli doorashada (1-2): ");
        int bil = scanner.nextInt();
        scanner.nextLine();

        switch (bil) {
            case 1:
                //post paid
                System.out.println("\nPost paid:");
                System.out.println("1. Ogow biilka");
                System.out.println("2. Bixi Biil");
                System.out.println("3. Ka bixi biil");
                System.out.print("Geli doorashada (1-3): ");
                int pp = scanner.nextInt();
                scanner.nextLine();

                switch (pp) {
                    case 1:
                        //ogow biilka
                        System.out.println("Haraagaagu waa: $" + balance);
                        addAction("Ogow biilka");
                        break;

                    case 2:
                        //bixi biilka
                        System.out.print("Fadlan gali lacagta: $");
                        double ba = scanner.nextDouble();
                        scanner.nextLine();

                        if (ba <= 0) {
                            System.out.println("Haraagaaga kuguma filna");
                            break;
                        }

                        System.out.println("Ma hubtaa inaad bixisid biil lacagtiisa tahay: $" + ba + "?");
                        System.out.println("1. Haa");
                        System.out.println("2. Maya");
                        System.out.print("Geli doorashada: ");
                        int cb = scanner.nextInt();
                        scanner.nextLine();

                        if (cb == 1) {
                            if (ba <= balance) {
                                balance -= ba;
                                System.out.println("Biilka si guul leh ayaa loo bixiyay");
                                System.out.println("Haraaga cusub: $" + balance);
                                addAction("Bixi biil $" + ba);
                            } else {
                                System.out.println("Haraagaaga kuguma filna");
                            }
                        } else {
                            System.out.println("Macsalaamo");
                        }
                        break;

                    case 3:
                        //ka bixi biilka
                        System.out.print("Fadlan gali mobile-ka: ");
                        String kb = scanner.nextLine();

                        System.out.print("Fadlan gali lacagta: $");
                        double bla = scanner.nextDouble();
                        scanner.nextLine();

                        if (bla <= 0) {
                            System.out.println("Haraagaaga kuguma filna");
                            break;
                        }

                        System.out.println("Ma hubtaa inaad bixisid biil lacagtiisa tahay: $" + bla + " oo laga rabo " + kb + "?");
                        System.out.println("1. Haa");
                        System.out.println("2. Maya");
                        System.out.print("Geli doorashada: ");
                        int cbp = scanner.nextInt();
                        scanner.nextLine();

                        if (cbp == 1) {
                            if (bla <= balance) {
                                balance -= bla;
                                System.out.println("Biilka si guul leh ayaa loo bixiyay");
                                System.out.println("Haraaga cusub: $" + balance);
                                addAction("Ka bixi biil $" + bla + " to " + kb);
                            } else {
                                System.out.println("Haraagaaga kuguma filna");
                            }
                        } else {
                            System.out.println("Macsalaamo");
                        }
                        break;

                    default:
                        System.out.println("Doorashada aad dooratay ma saxan tahay");
                        break;
                }
                break;

            case 2:
                //iibso
                System.out.print("Fadlan gali aqoonsiga ganacsiga: ");
                String aq = scanner.nextLine();
                System.out.println("Waxaad ku iibsatey ganacsiga: " + aq);
                addAction("Ku iibso ganacsiga " + aq);
                break;

            default:
                System.out.println("Doorashada aad dooratay ma saxan tahay");
                break;
        }
    }
    //qaybta u wareeji evc plus
    private static void UwareejiEVCPlus(Scanner scanner) {
        System.out.print("\nFadlan gali mobile-ka: ");
        String tn = scanner.nextLine();

        System.out.print("Fadlan gali lacagta: $");
        double ta = scanner.nextDouble();
        scanner.nextLine();

        if (ta <= 0) {
            System.out.println("Haraagaaga kuguma filna");
            return;
        }

        System.out.println("Ma hubtaa inaad u direyso $" + ta + " numberka " + tn + "?");
        System.out.println("1. Haa");
        System.out.println("2. Maya");
        System.out.print("Geli doorashada: ");
        int ct = scanner.nextInt();
        scanner.nextLine();

        if (ct == 1) {
            if (ta <= balance) {
                balance -= ta;
                lastTransferNumber = tn;
                lastTransferAmount = ta;
                System.out.println("Waxaad u wareejisay $" + ta + " numberka " + tn);
                System.out.println("Haraaga cusub: $" + balance);
                addAction("U wareeji $" + ta + " to " + tn);
            } else {
                System.out.println("Haraagaaga kuguma filna");
            }
        } else {
            System.out.println("Macsalaamo");
        }
    }

        //qaybta warbiixn kooban
    private static void WarbixinKooban(Scanner scanner) {



        System.out.println("\nWarbixin Kooban:");

        System.out.println("1.Last Action\n" +
                "2.Wareejintii u dambeysay\n" +
                "3.Iibsashadii U dambeysay\n" +
                "4.Last 3 actions\n" +
                "5.Email my last activity");
        int war = scanner.nextInt();

        switch (war) {
            case 1:
                //last actions
                LocalDateTime maanta = LocalDateTime.now();
                System.out.println("10$ Ayaad ka heshay 252619880131." );
                break;

            case 2:
                //wareejintii u dambeysey
                System.out.println("Statementiga:\n1.u dirtay\n2.Ka heshay");
                int state = scanner.nextInt();

                if (state == 1 || state == 2) {
                    System.out.println("Fadlan geli number-ka");
                    int lambar = scanner.nextInt();
                    System.out.println("Your mini statement has been sent as SMS to your registered mobile no");
                } else {
                    System.out.println("Fadlan dooro number sax ah");
                }
                break;

            case 3:
                //iibsashadii u dambeysey
                System.out.println("Fadlan geli aqoonsiga ganacsiga");
                int iibso = scanner.nextInt();
                String ganacsade_name = "WAAYA ARAG";
                int ganacsade = 223424166;

                if (iibso == ganacsade) {
                    maanta = LocalDateTime.now();
                    System.out.println("10$ Ayaad uga iibsatay ganacsade " + ganacsade_name + " " + iibso );
                } else {
                    System.out.println("Operation succeeded\nNO Transactions to display!");
                }
                break;

            case 4:
                //last 3 actions
                System.out.println("Yor mini statement has been sent as SMS to your registered mobile no");
                break;

            case 5:
                //Email my activity
                System.out.println("Fadlan geli email-kaga");
                String emayl = scanner.next();
                System.out.println("Fadlan geli taariikhda hore,\n(MAALIN/BISHA/SANADKA e.g 01/04/2017)");
                String tarikh_hore = scanner.next();
                System.out.println("Fadlan geli taariikhda danbe,\n(MAALIN/BISHA/SANADKA e.g 30/04/2017)");
                String tarikh_danbe = scanner.next();
                System.out.println("your request is been processed and the activity will be emailed to " + emayl);
                break;

            default:
                System.out.println("Fadlan dooro number sax ah");
        }

    }

    ///qaybta salaam bank

    private static void salaamBank(Scanner scanner) {
            System.out.println("\nSalaam Bank:");
            System.out.println("1. Itus haraagaga");
            System.out.println("2. Lacag dhigasho");
            System.out.println("3. Lacag qaadasho");
            System.out.println("4. Ka wareeji Evc Plus");
            System.out.print("Geli doorashada (1-4): ");
            int bn = scanner.nextInt();
            scanner.nextLine();

            //itus haraagaaga
            if (bn == 1) {
                System.out.println("Haraaga bankigaagu waa: $" + balance);
                addAction("Bank balansiga eegis");

                ////Lacag dhiga sho
            } else if (bn == 2) {
                System.out.print("Fadlan gali lacagta aad dhigeysid: $");
                double da = scanner.nextDouble();
                scanner.nextLine();

                if (da <= 0) {
                    System.out.println("Haraagaaga kuguma filna");
                } else {
                    System.out.println("Ma hubtaa inaad ku dhigtid $" + da + " banka?");
                    System.out.println("1. Haa");
                    System.out.println("2. Maya");
                    System.out.print("Geli doorashada: ");
                    int cd = scanner.nextInt();
                    scanner.nextLine();

                    if (cd == 1) {
                        balance += da;
                        System.out.println("Waxaad ku dhigtay $" + da + " banka");
                        System.out.println("Haraaga cusub: $" + balance);
                        addAction("Bank deposit $" + da);
                    } else {
                        System.out.println("Macsalaamo");
                    }
                }

                //lacag qaadasho
            } else if (bn == 3) {
                System.out.print("Fadlan gali lacagta aad qaadeysid: $");
                double wa = scanner.nextDouble();
                scanner.nextLine();

                if (wa <= 0) {
                    System.out.println("Qadar macquul ah ma ahan");
                } else {
                    System.out.println("Ma hubtaa inaad ka qaadid $" + wa + " banka?");
                    System.out.println("1. Haa");
                    System.out.println("2. Maya");
                    System.out.print("Geli doorashada: ");
                    int wc = scanner.nextInt();
                    scanner.nextLine();

                    if (wc == 1) {
                        if (wa <= balance) {
                            balance -= wa;
                            System.out.println("Waxaad ka qaadatay $" + wa + " banka");
                            System.out.println("Haraaga cusub: $" + balance);
                            addAction("Bank withdraw $" + wa);
                        } else {
                            System.out.println("Haraagaaga kuguma filna");
                        }
                    } else {
                        System.out.println("macsalaamo");
                    }
                }

                //uwareeji lacagta
            } else if (bn == 4) {
                System.out.print("Fadlan gali lacagta aad wareejineysid: $");
                double tb = scanner.nextDouble();
                scanner.nextLine();

                if (tb <= 0) {
                    System.out.println("Haraagaaga kuguma filna");
                } else {
                    System.out.println("Ma hubtaa inaad u wareejisid $" + tb + " Evc Plus?");
                    System.out.println("1. Haa");
                    System.out.println("2. Maya");
                    System.out.print("Geli doorashada: ");
                    int confirmBankTransfer = scanner.nextInt();
                    scanner.nextLine();

                    if (confirmBankTransfer == 1) {
                        balance += tb;
                        System.out.println("Waxaad u wareejisay $" + tb + " Evc Plus");
                        System.out.println("Haraaga cusub: $" + balance);
                        addAction("Bank transfer to EVC $" + tb);
                    } else {
                        System.out.println("Macsalaamp");
                    }
                }

            } else {
                System.out.println("Doorashada aad dooratay ma saxan tahay");
            }


    }




    /// qayta maaneynta
    private static void Maareynta(Scanner scanner) {
        System.out.println("\nMaareynta:");
        System.out.println("1. Bedel pin-ka");
        System.out.println("2. Bedel luqada");
        System.out.println("3. Wergelin mobile lumay");
        System.out.println("4. Lacag xirasho");
        System.out.println("5. U celi lacag qaldantay");
        System.out.print("Geli doorashada (1-5): ");
        int mr = scanner.nextInt();
        scanner.nextLine();

        //bedel pinkaaga
        if (mr == 1) {
            System.out.print("Fadlan gali pin-kaga cusub: ");
            String np1 = scanner.nextLine();
            System.out.print("Hubi pin-kaga cusub: ");
            String np2 = scanner.nextLine();

            if (np1.equals(np2)) {
                pin = np1;
                System.out.println("Waad ku guuleysatay inaad bedesho PIN-ka");
                addAction("Bedel PIN");
            } else {
                System.out.println("PIN-ka labaad waa khalad");
            }


            //bedel luuqada
        } else if (mr == 2) {
            System.out.println("\nFadlan dooro luqada:");
            System.out.println("1. Somali");
            System.out.println("2. English");
            System.out.println("3. Taliyaani");
            System.out.println("4. Spanish");
            System.out.print("Geli doorashada (1-4): ");
            int lq = scanner.nextInt();
            scanner.nextLine();

            if (lq == 1) {
                language = "Somali";
            } else if (lq == 2) {
                language = "English";
            } else if (lq == 3) {
                language = "Taliyaani";
            } else if (lq == 4) {
                language = "Spanish";
            } else {
                System.out.println("Doorashada aad dooratay ma saxan tahay");
            }

            if (lq >= 1 && lq <= 4) {
                System.out.println("Waad dooratay luqada " + language + ". Hambalyo!");
                addAction("Bedel luqada " + language);
            }

            //wargelin mobile lumay
        } else if (mr == 3) {
            System.out.print("Fadlan gali mobile-ka lumay: ");
            String ln = scanner.nextLine();
            System.out.print("Fadlan gali pin-ka: ");
            String lp = scanner.nextLine();

            if (lp.equals(pin)) {
                System.out.println("Waad ku guuleysatay! Mobile-kaga wuxu ku yaala xarunta kugudhaw ka doono mudane");
                addAction("Wergelin mobile lumay " + ln);
            } else {
                System.out.println("PIN khalad ah");
            }

            //lacag xirasho
        } else if (mr == 4) {
            System.out.print("Fadlan gali number-ka khalad-ka ah: ");
            String wn = scanner.nextLine();
            System.out.print("Fadlan gali number-kii loo rabay: ");
            String cn = scanner.nextLine();
            System.out.print("Fadlan gali macluumaad: ");
            String blockInfo = scanner.nextLine();

            System.out.println("Ma hubtaa inaad xirto lacagta?");
            System.out.println("1. Haa");
            System.out.println("2. Maya");
            System.out.print("Geli doorashada: ");
            int cb = scanner.nextInt();
            scanner.nextLine();

            if (cb == 1) {
                System.out.println("Lacagta waa la xiray");
                addAction("Lacag xirasho " + wn + " to " + cn);
            } else {
                System.out.println("Waa la joojiyay");
            }

            //uceli lacagta qaldantay
        } else if (mr == 5) {
            System.out.print("Fadlan gali aqoonsiga lacag dirida: ");
            String tid = scanner.nextLine();
            System.out.print("Fadlan gali macluumaad: ");
            String reverseInfo = scanner.nextLine();

            System.out.println("Ma hubtaa inaad celiso lacagta?");
            System.out.println("1. Haa");
            System.out.println("2. Maya");
            System.out.print("Geli doorashada: ");
            int cr = scanner.nextInt();
            scanner.nextLine();

            if (cr == 1) {
                System.out.println("Codsigaaga waa la qaatay");
                addAction("U celi lacag qaldantay " + tid);
            } else {
                System.out.println("macsalaamo");
            }

        } else {
            System.out.println("Doorashada aad dooratay ma saxan tahay");
        }
    }


    //qaybta bill pymentiga
    private static void billPyment(Scanner scanner) {
        System.out.println("\nBill payment:");
        System.out.println("1. Itus Haraaga");
        System.out.println("2. Wada bixi biil-ka");
        System.out.println("3. Qeyb ka bixi biil-ka");
        System.out.print("Geli doorashada (1-3): ");
        int bp = scanner.nextInt();
        scanner.nextLine();

        //itus haraagaaga
        if (bp == 1) {
            System.out.println("Haraagaagu waa: $" + balance);
            addAction("Balansiga eegis");

            //wada bixi biilk
        } else if (bp == 2) {
            System.out.print("Fadlan geli biil reference number: ");
            String rn = scanner.nextLine();
            System.out.println("Biilka " + rn + " waa la bixiyay");
            addAction("Wada bixi biil " + rn);

            //qayb ka bixi biilka
        } else if (bp == 3) {
            System.out.print("Fadlan geli biil reference number: ");
            String pn = scanner.nextLine();
            System.out.println("Qeyb ka biilka " + pn + " waa la bixiyay");
            addAction("Qeyb ka bixi biil " + pn);

        } else {
            System.out.println("Doorashada aad dooratay ma saxan tahay");
        }
    }

}
