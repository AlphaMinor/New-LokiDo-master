package com.lokido.isuru.lokido;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Drawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button btnLock;

    private EditText textLockName, newEmail, password, newPassword;
    private ProgressBar progressBar;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    int fingerprint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();


        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String nav_email = user.getEmail();


        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(Drawer.this, LoginActivity.class));
                    finish();
                }
            }
        };

        btnLock = (Button) findViewById(R.id.btnLock);

//        btnChangeEmail = (Button) findViewById(R.id.change_email_button);
//        btnChangePassword = (Button) findViewById(R.id.change_password_button);
//        btnSendResetEmail = (Button) findViewById(R.id.sending_pass_reset_button);
//        btnRemoveUser = (Button) findViewById(R.id.remove_user_button);
//        changeEmail = (Button) findViewById(R.id.changeEmail);
//        changePassword = (Button) findViewById(R.id.changePass);
//        sendEmail = (Button) findViewById(R.id.send);
//        remove = (Button) findViewById(R.id.remove);
//        signOut = (Button) findViewById(R.id.sign_out);
//
//        oldEmail = (EditText) findViewById(R.id.old_email);
//        newEmail = (EditText) findViewById(R.id.new_email);
//        password = (EditText) findViewById(R.id.password);
//        newPassword = (EditText) findViewById(R.id.newPassword);
//
//        oldEmail.setVisibility(View.GONE);
//        newEmail.setVisibility(View.GONE);
//        password.setVisibility(View.GONE);
//        newPassword.setVisibility(View.GONE);
//        changeEmail.setVisibility(View.GONE);
//        changePassword.setVisibility(View.GONE);
//        sendEmail.setVisibility(View.GONE);
//        remove.setVisibility(View.GONE);
//
//        progressBar = (ProgressBar) findViewById(R.id.progressBar);
//
//        if (progressBar != null) {
//            progressBar.setVisibility(View.GONE);
//        }
        btnLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Intent i = new Intent(v.getContext(), FingerprintActivity.class);
//                    startActivity(i);
                if (fingerprint == 1) {
                    v.setBackgroundColor(Color.GREEN);
                } else {
                    Intent x = new Intent(v.getContext(), FingerprintActivity.class);
                    startActivity(x);
                }

            }
        });
//
//        btnChangeEmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                oldEmail.setVisibility(View.GONE);
//                newEmail.setVisibility(View.VISIBLE);
//                password.setVisibility(View.GONE);
//                newPassword.setVisibility(View.GONE);
//                changeEmail.setVisibility(View.VISIBLE);
//                changePassword.setVisibility(View.GONE);
//                sendEmail.setVisibility(View.GONE);
//                remove.setVisibility(View.GONE);
//            }
//        });
//
//        changeEmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progressBar.setVisibility(View.VISIBLE);
//                if (user != null && !newEmail.getText().toString().trim().equals("")) {
//                    user.updateEmail(newEmail.getText().toString().trim())
//                            .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if (task.isSuccessful()) {
//                                        Toast.makeText(Drawer.this, "Email address is updated. Please sign in with new email id!", Toast.LENGTH_LONG).show();
//                                        signout();
//                                        progressBar.setVisibility(View.GONE);
//                                    } else {
//                                        Toast.makeText(Drawer.this, "Failed to update email!", Toast.LENGTH_LONG).show();
//                                        progressBar.setVisibility(View.GONE);
//                                    }
//                                }
//                            });
//                } else if (newEmail.getText().toString().trim().equals("")) {
//                    newEmail.setError("Enter email");
//                    progressBar.setVisibility(View.GONE);
//                }
//            }
//        });
//
//        btnChangePassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                oldEmail.setVisibility(View.GONE);
//                newEmail.setVisibility(View.GONE);
//                password.setVisibility(View.GONE);
//                newPassword.setVisibility(View.VISIBLE);
//                changeEmail.setVisibility(View.GONE);
//                changePassword.setVisibility(View.VISIBLE);
//                sendEmail.setVisibility(View.GONE);
//                remove.setVisibility(View.GONE);
//            }
//        });
//
//        changePassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progressBar.setVisibility(View.VISIBLE);
//                if (user != null && !newPassword.getText().toString().trim().equals("")) {
//                    if (newPassword.getText().toString().trim().length() < 6) {
//                        newPassword.setError("Password too short, enter minimum 6 characters");
//                        progressBar.setVisibility(View.GONE);
//                    } else {
//                        user.updatePassword(newPassword.getText().toString().trim())
//                                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<Void> task) {
//                                        if (task.isSuccessful()) {
//                                            Toast.makeText(Drawer.this, "Password is updated, sign in with new password!", Toast.LENGTH_SHORT).show();
//                                            signout();
//                                            progressBar.setVisibility(View.GONE);
//                                        } else {
//                                            Toast.makeText(Drawer.this, "Failed to update password!", Toast.LENGTH_SHORT).show();
//                                            progressBar.setVisibility(View.GONE);
//                                        }
//                                    }
//                                });
//                    }
//                } else if (newPassword.getText().toString().trim().equals("")) {
//                    newPassword.setError("Enter password");
//                    progressBar.setVisibility(View.GONE);
//                }
//            }
//        });
//
//        btnSendResetEmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                oldEmail.setVisibility(View.VISIBLE);
//                newEmail.setVisibility(View.GONE);
//                password.setVisibility(View.GONE);
//                newPassword.setVisibility(View.GONE);
//                changeEmail.setVisibility(View.GONE);
//                changePassword.setVisibility(View.GONE);
//                sendEmail.setVisibility(View.VISIBLE);
//                remove.setVisibility(View.GONE);
//            }
//        });
//
//        sendEmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progressBar.setVisibility(View.VISIBLE);
//                if (!oldEmail.getText().toString().trim().equals("")) {
//                    auth.sendPasswordResetEmail(oldEmail.getText().toString().trim())
//                            .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if (task.isSuccessful()) {
//                                        Toast.makeText(Drawer.this, "Reset password email is sent!", Toast.LENGTH_SHORT).show();
//                                        progressBar.setVisibility(View.GONE);
//                                    } else {
//                                        Toast.makeText(Drawer.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
//                                        progressBar.setVisibility(View.GONE);
//                                    }
//                                }
//                            });
//                } else {
//                    oldEmail.setError("Enter email");
//                    progressBar.setVisibility(View.GONE);
//                }
//            }
//        });
//
//        btnRemoveUser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progressBar.setVisibility(View.VISIBLE);
//                if (user != null) {
//                    user.delete()
//                            .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if (task.isSuccessful()) {
//                                        Toast.makeText(Drawer.this, "Your profile is deleted:( Create a account now!", Toast.LENGTH_SHORT).show();
//                                        startActivity(new Intent(Drawer.this, SignupActivity.class));
//                                        finish();
//                                        progressBar.setVisibility(View.GONE);
//                                    } else {
//                                        Toast.makeText(Drawer.this, "Failed to delete your account!", Toast.LENGTH_SHORT).show();
//                                        progressBar.setVisibility(View.GONE);
//                                    }
//                                }
//                            });
//                }
//            }
//        });

//        signOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                signout();
//            }
//        });


//        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                fab.setDrawerIndicatorEnabled(false);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hView = navigationView.getHeaderView(0);
        TextView nav_user = (TextView) hView.findViewById(R.id.textViewUserEmail);

        nav_user.setText(nav_email);
        System.out.println("User details................." + user);


    }

    //sign out method
//    public void signOut() {
//        auth.signOut();
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        progressBar.setVisibility(View.GONE);
//    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {
            System.out.println("signout is working");
            signout();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent i = new Intent(this, Drawer.class);
            startActivity(i);
            return true;
        } else if (id == R.id.nav_logbook) {

            return true;

        } else if (id == R.id.nav_map) {
            checkLocationPermission();
            finish();
            return true;
        } else if (id == R.id.nav_settings) {
            Intent i = new Intent(this, UserSettingsActivity.class);
            startActivity(i);
            return true;
        } else if (id == R.id.nav_about) {

        } else if (id == R.id.nav_help) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void checkLocationPermission() {
//
        if (ActivityCompat.checkSelfPermission(Drawer.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Drawer.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Drawer.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            return;
        } else {
            // Write you code here if permission already given.
            Intent intent = new Intent(Drawer.this, MapsActivity.class);
            startActivity(intent);
        }
    }

    public void signout() {

        auth.signOut();
        startActivity(new Intent(Drawer.this, LoginActivity.class));
    }

    public Drawer drawer;

    public void unlock(Drawer drawer) {
        this.drawer = drawer;

        System.out.println("LOgin SUCCESSSSSSSSSSS N!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        btnLock.callOnClick();

        fingerprint = 1;
        //                btnLock.setBackgroundColor(Color.GREEN);
    }
}
